package org.ssm.zhb.biz.statePattern.context;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.ssm.zhb.biz.statePattern.impl.*;
import org.ssm.zhb.biz.statePattern.stateInterface.PersonStateI;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/416:41
 */
public class Person {

    private int hour;

    private PersonStateI personStateI;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void doSth() {
        if (this.hour == 7) {
            System.out.println("起床了！");
        } else if (this.hour == 11) {
            System.out.println("吃中饭了！");
        } else if (this.hour == 19) {
            System.out.println("吃晚饭了！");
        } else if (this.hour == 22) {
            System.out.println("睡觉了！");
        } else {
            System.out.println("学习呢!");
        }
    }

    public void doSth2() {
        if (this.hour == 7) {
            personStateI = new GetUp();
            personStateI.doSth();
        } else if (this.hour == 11) {
            personStateI = new HaveLunch();
            personStateI.doSth();
        } else if (this.hour == 19) {
            personStateI = new HaveDinner();
            personStateI.doSth();
        } else if (this.hour == 22) {
            personStateI = new Sleep();
            personStateI.doSth();
        } else {
            personStateI = new Study();
            personStateI.doSth();
        }
    }
}
