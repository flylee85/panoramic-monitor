package com.monitor.service.intothefactoryrecords;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.intothefactoryrecords.PanoramicIntoTheFactoryRecordsService;
import com.monitor.mapper.intothefactoryrecords.PanoramicIntoTheFactoryRecordsMapper;
import com.monitor.model.intothefactoryrecords.PanoramicIntoTheFactoryRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * @author summer
 * 2017/11/29
 */
@Service("intoTheFactoryRecordsService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicIntoTheFactoryRecordsServiceImpl extends AbstractService<PanoramicIntoTheFactoryRecords> implements PanoramicIntoTheFactoryRecordsService {
    @Autowired
    @Qualifier("intoTheFactoryRecordsMapper")
    private PanoramicIntoTheFactoryRecordsMapper intoTheFactoryRecordsMapper;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicIntoTheFactoryRecords> listByDate(String date) {
        Condition condition = new Condition(PanoramicIntoTheFactoryRecords.class, false);
        condition.createCriteria().andCondition(" delete_flag=1 and status=1 and date_format(out_time,'%Y%m%d') = date_format('" + date + "','%Y%m%d') ");
        condition.setOrderByClause(" status asc ");
        condition.setOrderByClause(" out_time desc ");
        List<PanoramicIntoTheFactoryRecords> factoryRecords = intoTheFactoryRecordsMapper.selectByCondition(condition);
        return factoryRecords;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public PanoramicIntoTheFactoryRecords findByDate(String date) {
        Condition condition = new Condition(PanoramicIntoTheFactoryRecords.class, false);
        condition.createCriteria().andCondition(" delete_flag=1 and status=1 and date_format(out_time,'%Y%m%d') = date_format('" + date + "','%Y%m%d') ");
        condition.setOrderByClause(" out_time desc ");
        List<PanoramicIntoTheFactoryRecords> factoryRecords = intoTheFactoryRecordsMapper.selectByCondition(condition);
        return (null == factoryRecords || factoryRecords.size() == 0) ? null : factoryRecords.get(0);
    }

    @Override
    public Integer count(String date) {
        Condition condition = new Condition(PanoramicIntoTheFactoryRecords.class, false);
        condition.createCriteria().andCondition(" delete_flag=1 and status=1 and date_format(out_time,'%Y%m%d') = date_format('" + date + "','%Y%m%d') ");
        Integer count = intoTheFactoryRecordsMapper.selectCountByCondition(condition);
        return count;
    }
}
