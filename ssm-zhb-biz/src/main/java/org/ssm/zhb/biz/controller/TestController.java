package org.ssm.zhb.biz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/testRequest", method = RequestMethod.GET)
    @ResponseBody
    private JSONObject testRequest(@RequestParam String testParam) {
        throw new BusinessException(ReturnCodeEnum.ERROR_14002, "大苏打");
//        return getSuccessResult(null);
    }

    @RequestMapping(value = "/testRequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private JSONObject postRequest(@RequestBody String jsonData) {
        logger.info("日志测试");
        return getSuccessResult(null);
    }

}
