package strategyPattern.factory;

import strategyPattern.enums.StrategyEnum;
import strategyPattern.strategyI.StrategyI;
import strategyPattern.strategyImpl.StrategyAImpl;
import strategyPattern.strategyImpl.StrategyBImpl;
import strategyPattern.strategyImpl.StrategyCImpl;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/418:19
 */
public class StrategyFactory {

    public static StrategyI createStrategy(StrategyEnum strategyEnum) {
        switch (strategyEnum) {
            case A:
                return new StrategyAImpl();
            case B:
                return new StrategyBImpl();
            case C:
                return new StrategyCImpl();
                default:
                    return null;
        }
    }

}
