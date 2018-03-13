package org.ssm.zhb.biz.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.ssm.zhb.common.basic.controller.BaseController;
import com.alibaba.fastjson.JSONObject;
import org.ssm.zhb.common.basic.enums.ReturnCodeEnum;
import org.ssm.zhb.common.basic.exception.BusinessException;

/**
 * @Title: TestController.class
 * @Package: org.ssm.zhb.biz.controller
 * @Descriptiom: 系统测试controller
 * @author: zhenghanbin
 * @date 2018/3/9 10:24
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @RequestMapping(value = "/testRequest", method = RequestMethod.GET)
        @ResponseBody
    private JSONObject testRequest(@RequestParam String testParam) {
        throw new BusinessException(ReturnCodeEnum.ERROR_14002, "大苏打");
//        return getSuccessResult(null);
    }

    @RequestMapping(value = "/testRequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private JSONObject postRequest(@RequestBody String jsonData) {
        return getSuccessResult(null);
    }

}
