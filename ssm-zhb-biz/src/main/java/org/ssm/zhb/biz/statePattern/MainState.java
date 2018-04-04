package org.ssm.zhb.biz.statePattern;

import org.ssm.zhb.biz.statePattern.context.Person;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/416:47
 */
public class MainState {

    public static void main(String[] args) {
        Person person = new Person();
        person.setHour(7);
        person.doSth();
        person.doSth2();

        person.setHour(11);
        person.doSth();
        person.doSth2();

        person.setHour(19);
        person.doSth();
        person.doSth2();

        person.setHour(22);
        person.doSth();
        person.doSth2();

        person.setHour(14);
        person.doSth();
        person.doSth2();

    }
}
