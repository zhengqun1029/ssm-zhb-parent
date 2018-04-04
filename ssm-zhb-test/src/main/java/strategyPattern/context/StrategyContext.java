package strategyPattern.context;

import strategyPattern.enums.StrategyEnum;
import strategyPattern.factory.StrategyFactory;
import strategyPattern.strategyI.StrategyI;

/**
 * @Title: strategyPattern.context
 * @Package: StrategyContext
 * @Descriptiom: 策略模式场景类
 * @author: zhenghanbin
 * @date 2018/4/418:04
 */
public class StrategyContext {

    private StrategyI strategy;

    public StrategyContext(StrategyEnum strategyEnum) {
        this.strategy = StrategyFactory.createStrategy(strategyEnum);
    }

    public void functionA() {
        strategy.functionA();
    }

    public String functionB(String param) {
        return strategy.functionB(param);
    }

    public Integer functionC(Integer param) {
        return strategy.functionC(param);
    }
}
