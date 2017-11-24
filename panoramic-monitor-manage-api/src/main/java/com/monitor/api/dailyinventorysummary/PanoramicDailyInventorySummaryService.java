package com.monitor.api.dailyinventorysummary;

import com.cloud.core.Service;
import com.monitor.model.dailyinventorysummary.PanoramicDailyInventorySummary;


/**
 * 库存服务
 *
 * @author summer
 * 2017/11/21.
 */
public interface PanoramicDailyInventorySummaryService extends Service<PanoramicDailyInventorySummary> {

    /**
     * 根据日期和物料编码查询库存（每种物料每天只有一条库存记录）
     *
     * @param code
     * @param date
     * @return
     */
    PanoramicDailyInventorySummary queryByDateAndCode(String code, String date);
}
