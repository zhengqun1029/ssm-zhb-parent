package org.ssm.zhb.common.basic.enums;

import org.ssm.zhb.common.basic.exception.BusinessException;

/**
 * @Title: ReturnCodeEnum.class
 * @Package: org.ssm.zhb.common.basic.enums
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/3/9 10:35
 */
public enum ReturnCodeEnum {
    SUCCESS(12000, "OK", "成功"),
    API_ERR400(14000, "Bad Request", ""),
    ERROR_14001(14001, "Bad Request Sign", ""),
    ERROR_14002(14002, "Bad Request Parameter", "请求参数[%s]错误!"),
    ERROR_14003(14003, "Bad Request SQL", ""),
    ERROR_14004(14004, "Bad Request State", ""),
    ERROR_14010(14010, "Unauthorized", ""),
    ERROR_14011(14011, "Unauthorized Session", ""),
    ERROR_14041(14041, "Not Found Method", ""),
    ERROR_14042(14042, "Not Found Data", ""),
    ERROR_14051(14051, "Method Not Allowed Role", ""),
    ERROR_14052(14052, "Method Not Allowed Data", ""),
    ERROR_15001(15001, "Internal Server Error Unknown", "系统未知错误，请排查"),
    ERROR_15002(15002, "Internal Server Error Impossible", ""),
    ERROR_15021(15021, "Internal Server Remove Monitor", ""),
    ERROR_16001(16001, "交易缺少参数", ""),
    ERROR_16003(16003, "service error", "系统繁忙，请稍后再试或联系相关人员"),
    ERROR_16004(16004, "service error", "系统处理异常[%s]"),
    ;

    private Integer key;
    /**
     * 响应码描述
     */
    private String desc;
    /**
     * 响应码提示语
     */
    private String remark;

    public Integer getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public String getRemark() {
        return remark;
    }

    ReturnCodeEnum(Integer key, String desc, String remark) {
        this.key = key;
        this.desc = desc;
        this.remark = remark;
    }

    public static ReturnCodeEnum valueof(Integer key) {
        if (key != null) {
            for(ReturnCodeEnum enums : ReturnCodeEnum.values()) {
                if (key.equals(enums.getKey())) {
                    return enums;
                }
            }
        }
        throw new BusinessException(ReturnCodeEnum.ERROR_16004, "系统响应码" +  key + "不合法!");
    }


}
