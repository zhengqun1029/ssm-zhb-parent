package org.ssm.zhb.biz.statePattern.impl;

import org.ssm.zhb.biz.statePattern.stateInterface.PersonStateI;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/416:54
 */
public class GetUp implements PersonStateI {

    public void doSth() {
        System.out.println("起床了！");
    }
}
