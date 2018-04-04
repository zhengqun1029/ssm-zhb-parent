package strategyPattern.enums;

/**
 * @Title: ${file_name}
 * @Package: ${package_name}
 * @Descriptiom: ${todo}
 * @author: zhenghanbin
 * @date 2018/4/418:24
 */
public enum StrategyEnum {
    A("A", ""),
    B("B", ""),
    C("C", ""),
    ;
    private String key;
    private String desc;

    StrategyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

}
