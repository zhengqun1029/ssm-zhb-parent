package strategyPattern.strategyImpl;

import strategyPattern.strategyI.StrategyI;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/4 18:15
 */
public class StrategyCImpl implements StrategyI {

    public void functionA() {
        System.out.println("StrategyCImpl.functionA()实现！");
    }

    public String functionB(String param) {
        System.out.println("StrategyCImpl.functionB()实现！传入字符串参数:" + param);
        return param;
    }

    public Integer functionC(Integer param) {
        System.out.println("StrategyCImpl.functionC()实现！传入整型参数:" + param);
        return param;
    }
}
