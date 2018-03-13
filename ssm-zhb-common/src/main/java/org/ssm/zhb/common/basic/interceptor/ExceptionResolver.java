package org.ssm.zhb.common.basic.interceptor;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.ssm.zhb.common.basic.bean.dto.ResultDto;
import org.ssm.zhb.common.basic.enums.ReturnCodeEnum;
import org.ssm.zhb.common.basic.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title: ExceptionHandelResolver.class
 * @Package: org.ssm.zhb.common.basic.interceptor
 * @Descriptiom: 全局异常处理
 * @author: zhenghanbin
 * @date 2018/3/9 16:01
 */
//@Component
public class ExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ResultDto resultDto = new ResultDto();
        if(e instanceof BusinessException) {
            this.resolverBusinessException((BusinessException) e, resultDto);
        } else {
            this.resolverException(e, resultDto);
        }
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            httpServletResponse.getOutputStream().write(JSON.toJSONString(resultDto).getBytes("UTF-8"));
        } catch (IOException ex) {
            logger.error("与客户端通讯异常：" + ex.getMessage(), ex);
        }
        return new ModelAndView();
    }

    private void resolverBusinessException(BusinessException e, ResultDto resultDto) {
        resultDto.setReturnCode(e.getErrorCode());
        resultDto.setDes(e.getMessage());
    }

    private void resolverException(Exception e, ResultDto resultDto) {
        resultDto.setReturnCode(ReturnCodeEnum.ERROR_16003.getKey());
        resultDto.setDes(ReturnCodeEnum.ERROR_16003.getRemark());
    }
}
