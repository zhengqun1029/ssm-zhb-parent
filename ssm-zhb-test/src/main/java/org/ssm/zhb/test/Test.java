package org.ssm.zhb.test;

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

    public static void main(String[] args) {
        doMatchForver();
    }
}
