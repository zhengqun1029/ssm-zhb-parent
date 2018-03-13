package org.ssm.zhb.common.basic.bean.dto;

import org.ssm.zhb.common.basic.enums.ReturnCodeEnum;
import org.ssm.zhb.common.basic.exception.BusinessException;

/**
 * @Title: ResultDto.class
 * @Package: com.pay.fee.org.ssm.zhb.common.basic
 * @Descriptiom: 数据传出公共Bean
 * @author: zhenghanbin
 * @date 2018/2/26 10:41
 */
public class ResultDto<T> {

    /**
     * 应答Code
     */
    private Integer returnCode = ReturnCodeEnum.ERROR_15001.getKey();
    /**
     * 应答说明
     */
    private String des;
    /**
     * 数据对象
     */
    protected T data;

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        if (!(returnCode == ReturnCodeEnum.SUCCESS.getKey())) {
            ReturnCodeEnum returnCodeEnum = ReturnCodeEnum.valueof(returnCode);
            des = String.format(returnCodeEnum.getRemark(), des);
        }
        this.des = des;
    }
}
