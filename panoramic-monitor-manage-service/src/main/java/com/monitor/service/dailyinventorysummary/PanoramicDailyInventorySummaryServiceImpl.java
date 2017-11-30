package com.monitor.service.dailyinventorysummary;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.monitor.api.dailyinventorysummary.PanoramicDailyInventorySummaryService;
import com.monitor.mapper.dailyinventorysummary.PanoramicDailyInventorySummaryMapper;
import com.monitor.model.dailyinventorysummary.PanoramicDailyInventorySummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("dailyInventorySummaryService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicDailyInventorySummaryServiceImpl extends AbstractService<PanoramicDailyInventorySummary> implements PanoramicDailyInventorySummaryService {
    @Autowired
    @Qualifier("dailyInventorySummaryMapper")
    private PanoramicDailyInventorySummaryMapper dailyInventorySummaryMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public PanoramicDailyInventorySummary queryByDateAndCode(String code, String date) {
        Condition condition = new Condition(PanoramicDailyInventorySummary.class, false);
        condition.createCriteria().andCondition(" code ='" + code + "' and f_id=2 and delete_flag=1 and utime > '" + DateUtil.parseTimestamp(date, "yyyy-MM-dd") + "' and  utime < '" + DateUtil.parseTimestamp(DateUtil.getSpecifiedDayBefor(date, -1), "yyyy-MM-dd") + "'");
        condition.setOrderByClause(" utime desc ");
        List<PanoramicDailyInventorySummary> recordList = dailyInventorySummaryMapper.selectByCondition(condition);
        return (null == recordList || recordList.size() == 0) ? null : recordList.get(0);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicDailyInventorySummary> listByDateAndCode(String date) {
        Condition condition = new Condition(PanoramicDailyInventorySummary.class, false);
        condition.createCriteria().andCondition(" f_id=2 and delete_flag=1 and utime > '" + DateUtil.parseTimestamp(date, "yyyy-MM-dd") + "' and  utime < '" + DateUtil.parseTimestamp(DateUtil.getSpecifiedDayBefor(date, -1), "yyyy-MM-dd") + "'");
        condition.setOrderByClause(" utime desc ");
        List<PanoramicDailyInventorySummary> recordList = dailyInventorySummaryMapper.selectByCondition(condition);
        return recordList;
    }
}
