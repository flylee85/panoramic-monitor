package com.monitor.service.exceptionrecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.monitor.api.exceptionrecord.PanoramicExceptionRecordService;
import com.monitor.mapper.exceptionrecord.PanoramicExceptionRecordMapper;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;

import tk.mybatis.mapper.entity.Condition;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("panoramicExceptionRecordService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class PanoramicExceptionRecordServiceImpl extends AbstractService<PanoramicExceptionRecord> implements PanoramicExceptionRecordService {
    @Autowired
    @Qualifier("panoramicExceptionRecordMapper")
    private PanoramicExceptionRecordMapper panoramicExceptionRecordMapper;

    /**
     * 方法上不需要事务
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicExceptionRecord> listByCategory(String category, String date) {
        Condition condition = new Condition(PanoramicExceptionRecord.class, false);
        condition.createCriteria().andCondition(" alarm_time >'" +date+ "' and status=0 and alarm_item = '" + category + "'");
        condition.setOrderByClause(" status asc ");
        condition.setOrderByClause(" alarm_time desc ");
        List<PanoramicExceptionRecord> recordList = panoramicExceptionRecordMapper.selectByCondition(condition);
        return recordList;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public List<PanoramicExceptionRecord> queryAll(String date) {
        Condition condition = new Condition(PanoramicExceptionRecord.class, false);
        condition.createCriteria().andCondition(" status=0 and alarm_time >'" + date + "'");
        condition.setOrderByClause(" status asc ");
        condition.setOrderByClause(" alarm_time desc ");
        List<PanoramicExceptionRecord> recordList = panoramicExceptionRecordMapper.selectByCondition(condition);
        return recordList;
    }
}
