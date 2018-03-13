package org.ssm.zhb.common.basic.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.MediaType;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.ssm.zhb.common.basic.BaseConstant;
import org.ssm.zhb.common.basic.enums.ReturnCodeEnum;
import org.ssm.zhb.common.basic.exception.BusinessException;
import org.ssm.zhb.common.basic.wrapper.CacheRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;

/**
 * @Title: LoggerFilter.class
 * @Package: org.ssm.zhb.common.basic.filter
 * @Descriptiom: 系统基础功能过滤器（日志唯一标识ID生成及请求参数，响应参数输出）
 * @author: zhenghanbin
 * @date 2018/3/9 15:38
 */
public class LoggerFilter implements Filter {

    private static final String REQUEST_METHOD_GET = "GET";
    private static final String REQUEST_METHOD_POST = "POST";

    private static final transient Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

    ServletContext context;

    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 生成日志唯一Id
        this.createLoggerToken();
        // 输出请求及响应信息
        CacheRequestWrapper requestWrapper = new CacheRequestWrapper((HttpServletRequest) request);
        requestWrapper.setCharacterEncoding("UTF-8");
        requestWrapper.setAttribute("startTime", System.currentTimeMillis());
        this.printRequestLoggerInfo(requestWrapper);
        // springMVC实现的HttpServletResponseWrapper实现类，推荐使用
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);
        wrappedResponse.setCharacterEncoding("UTF-8");
        chain.doFilter(requestWrapper, wrappedResponse);
        byte[] data = wrappedResponse.getContentAsByteArray();
        wrappedResponse.copyBodyToResponse();
        String dataStr = new String(data, "UTF-8");
        Long costTime = System.currentTimeMillis() - (Long) request.getAttribute("startTime");
        logger.info("请求处理完成，响应信息:{},接口总耗时:{}ms", dataStr, costTime);
        // 删除日志唯一ID
        MDC.remove(BaseConstant.Framework.Logger.LOGGER_TOKEN_KEY);
    }

    public void destroy() {
    }

    private void printRequestLoggerInfo(CacheRequestWrapper wrappedRequest) {
        StringBuffer url = wrappedRequest.getRequestURL();                //请求的全路径,比如:http://localhost:8080/ssm-zhb-parent/test/testRequest
        wrappedRequest.setAttribute("startTime", System.currentTimeMillis());
        if (REQUEST_METHOD_GET.equals(wrappedRequest.getMethod())) {
            // 获取请求参数
            String param = wrappedRequest.getQueryString();
            logger.info("请求:{} 处理开始！请求访问方式:{}，请求参数:{}", url.toString(), wrappedRequest.getMethod(), param);
        } else {
            if (MediaType.APPLICATION_JSON_VALUE.equals(wrappedRequest.getContentType())) {
                InputStream iStream = null;
                BufferedReader bReader = null;
                try {
                    StringBuffer sBuilder = new StringBuffer();
                    iStream = wrappedRequest.getInputStream();
                    bReader = new BufferedReader(new InputStreamReader(iStream, Charset.forName("UTF-8")));
                    String line;
                    while ((line = bReader.readLine()) != null) {
                        sBuilder.append(line);
                    }
                    System.out.println(sBuilder.toString());
                    logger.info("请求:{} 处理开始！请求访问方式:{}，请求参数:{}", url.toString(), wrappedRequest.getMethod(), sBuilder.toString());
                } catch (IOException e) {
                    logger.error("流转换异常！", e);
                    throw new BusinessException("流转换异常！");
                } finally {
                    if (iStream != null) {
                        try {
                            iStream.close();
                            bReader.close();
                        } catch (IOException e) {
                            logger.error("流关闭异常！", e);
                            throw new BusinessException("流关闭异常！");
                        }
                    }
                }
            } else {
                throw new BusinessException(ReturnCodeEnum.ERROR_16004, "请求contextType不合规！");
            }
        }
    }

    /**
     * @param
     * @return void
     * @throws
     * @Description: 生成日志唯一Id
     * @author zhenghanbin
     * @date 2018/3/8 10:28
     */
    private void createLoggerToken() {
        // 日志输出生成唯一ID
        String token = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        logger.debug("****************" + token + "*************************");
        MDC.put(BaseConstant.Framework.Logger.LOGGER_TOKEN_KEY, token);
    }
}
