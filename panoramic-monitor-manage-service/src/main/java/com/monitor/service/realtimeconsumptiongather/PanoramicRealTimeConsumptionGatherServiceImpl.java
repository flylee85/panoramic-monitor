package com.monitor.service.realtimeconsumptiongather;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.monitor.api.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherService;
import com.monitor.mapper.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherMapper;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
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
@Service("realTimeConsumptionGatherService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicRealTimeConsumptionGatherServiceImpl extends AbstractService<PanoramicRealTimeConsumptionGather> implements PanoramicRealTimeConsumptionGatherService {
    @Autowired
    @Qualifier("realTimeConsumptionGatherMapper")
    private PanoramicRealTimeConsumptionGatherMapper realTimeConsumptionGatherMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicRealTimeConsumptionGather> listByCodeAndDate(String date, String code) {
        Condition condition = new Condition(PanoramicRealTimeConsumptionGather.class, false);
        condition.createCriteria().andCondition(" code ='" + code + "' and f_id=2 and delete_flag=1 and ctime > '" + DateUtil.parseTimestamp(date, "yyyy-MM-dd") + "' and  utime < '" + DateUtil.parseTimestamp(DateUtil.getSpecifiedDayBefor(date, -1), "yyyy-MM-dd") + "'");
        condition.setOrderByClause(" ctime asc ");
        List<PanoramicRealTimeConsumptionGather> recordList = realTimeConsumptionGatherMapper.selectByCondition(condition);
        return recordList;
    }
}
