package com.monitor.api.realtimeconsumptiongather;

import com.cloud.core.Service;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;

import java.util.List;


/**
* @author summer
* 2017/11/21.
*/
public interface PanoramicRealTimeConsumptionGatherService extends Service<PanoramicRealTimeConsumptionGather> {

    /** 根据时间和code查询实时消耗汇总数据
     * @param date
     * @param code
     * @return
     */
    List<PanoramicRealTimeConsumptionGather> listByCodeAndDate(String date, String code);
}
