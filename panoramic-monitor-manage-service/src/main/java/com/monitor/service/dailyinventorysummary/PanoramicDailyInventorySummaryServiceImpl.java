package com.monitor.service.dailyinventorysummary;

import com.cloud.core.AbstractService;
import com.monitor.api.dailyinventorysummary.PanoramicDailyInventorySummaryService;
import com.monitor.mapper.dailyinventorysummary.PanoramicDailyInventorySummaryMapper;
import com.monitor.model.dailyinventorysummary.PanoramicDailyInventorySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("panoramicDailyInventorySummaryService")
@Transactional
public class PanoramicDailyInventorySummaryServiceImpl extends AbstractService<PanoramicDailyInventorySummary> implements PanoramicDailyInventorySummaryService {
    @Autowired
    @Qualifier("panoramicDailyInventorySummaryMapper")
    private PanoramicDailyInventorySummaryMapper panoramicDailyInventorySummaryMapper;

}
