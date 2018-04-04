package org.ssm.zhb.test;

import strategyPattern.context.StrategyContext;
import strategyPattern.enums.StrategyEnum;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/3/1516:21
 */
public class Test {

    public static void doMatchForver() {
        int i = 0;
        for (;;) {
            i += 1;
            System.out.println(i);
            i += 2;
            System.out.println(i);
        }
    }

    public static void testStrategyPattern(StrategyEnum strategyEnum, String paramStr, Integer paramInt ) {
        StrategyContext context = new StrategyContext(strategyEnum);
        context.functionA();
        context.functionB(paramStr);
        context.functionC(paramInt);
    }

    public static void main(String[] args) {
//        doMatchForver();
        testStrategyPattern(StrategyEnum.A, "aaaaa", 1111);
        testStrategyPattern(StrategyEnum.B, "bbbbb", 2222);
        testStrategyPattern(StrategyEnum.C, "ccccc", 3333);
    }
}
