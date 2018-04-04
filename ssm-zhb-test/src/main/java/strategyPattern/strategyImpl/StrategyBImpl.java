package strategyPattern.strategyImpl;

import strategyPattern.strategyI.StrategyI;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/418:14
 */
public class StrategyBImpl implements StrategyI {

    public void functionA() {
        System.out.println("StrategyBImpl.functionA()实现！");
    }

    public String functionB(String param) {
        System.out.println("StrategyBImpl.functionB()实现！传入字符串参数:" + param);
        return param;
    }

    public Integer functionC(Integer param) {
        System.out.println("StrategyBImpl.functionC()实现！传入整型参数:" + param);
        return param;
    }
}
