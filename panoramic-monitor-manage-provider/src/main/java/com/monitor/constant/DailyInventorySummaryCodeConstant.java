package com.monitor.constant;

import org.apache.commons.collections.list.UnmodifiableList;

import java.util.Arrays;
import java.util.List;

/**
 * 首页查询code
 *
 * @author summer
 */
public class DailyInventorySummaryCodeConstant {
    public static final List<String> CODE_LIST;

    static {
        List<String> temp = Arrays.asList(
                "HG01XY750300",
                "HG01XY750200",
                "HG01XY750100",
                "HG01XY750000",
                "HG01XY750510",
                "HG01XY750410"
        );
        CODE_LIST = UnmodifiableList.decorate(temp);
    }

}
