package org.ssm.zhb.common.basic.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.zhb.common.basic.bean.dto.ResultDto;
import org.ssm.zhb.common.basic.enums.ReturnCodeEnum;
import org.ssm.zhb.common.basic.exception.BusinessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: BaseController.class
 * @Package: com.pay.fee.controller
 * @Descriptiom: 控制层基类
 * @author: zhenghanbin
 * @date 2018/1/3114:45
 */
public class BaseController {

    public JSONObject getSuccessResult(Object object) {
        ResultDto resultDto = new ResultDto();
        resultDto.setReturnCode(ReturnCodeEnum.SUCCESS.getKey());
        resultDto.setDes(ReturnCodeEnum.SUCCESS.getRemark());
        resultDto.setData(object);
        JSONObject resultJSON = JSONObject.parseObject(JSONObject.toJSONString(resultDto));
        return resultJSON;
    }

    /** 基于@ExceptionHandler异常处理 与 org.ssm.zhb.common.basic.interceptor.ExceptionResolver 二选其一 */
//    @ExceptionHandler
//    @ResponseBody
//    public ResultDto handleAndReturnData(HttpServletRequest request, HttpServletResponse response, Exception ex) {
//        ResultDto resultDto = new ResultDto();
//        if(ex instanceof BusinessException) {
//            BusinessException e = (BusinessException)ex;
//            resultDto.setReturnCode(e.getErrorCode());
//            resultDto.setDes(e.getMessage());
//        } else {
//            resultDto.setReturnCode(ReturnCodeEnum.ERROR_16003.getKey());
//            resultDto.setDes(ReturnCodeEnum.ERROR_16003.getRemark());
//        }
//        return resultDto;
//    }
}
