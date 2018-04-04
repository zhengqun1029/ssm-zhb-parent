package strategyPattern.strategyI;

/**
 * @Title: StrategyI
 * @Package: strategyPattern.strategyI
 * @Descriptiom: 策略模式接口
 * @author: zhenghanbin
 * @date 2018/4/418:06
 */
public interface StrategyI {
    // 算法一
    void functionA();
    // 算法二
    String functionB(String param);
    // 算法三
    Integer functionC(Integer param);
}
