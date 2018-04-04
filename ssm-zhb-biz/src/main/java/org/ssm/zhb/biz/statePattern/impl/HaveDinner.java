package org.ssm.zhb.biz.statePattern.impl;

import org.ssm.zhb.biz.statePattern.stateInterface.PersonStateI;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/416:55
 */
public class HaveDinner implements PersonStateI {
    public void doSth() {
        System.out.println("吃晚饭了！");
    }
}
