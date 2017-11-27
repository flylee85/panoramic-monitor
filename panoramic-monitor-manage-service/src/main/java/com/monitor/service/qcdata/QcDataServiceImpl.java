package com.monitor.service.qcdata;

import com.cloud.core.AbstractService;
import com.cloud.core.ServiceException;
import com.cloud.util.DateUtil;
import com.monitor.api.qcdata.QcDataService;
import com.monitor.mapper.qcdata.QcDataMapper;
import com.monitor.model.qcdata.QcData;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;


/**
 * @author  summer
 * 2017/11/27
 */
@Service("qcDataService")
@Transactional(readOnly = true, rollbackFor = ServiceException.class)
public class QcDataServiceImpl extends AbstractService<QcData> implements QcDataService {
    @Autowired
    @Qualifier("qcDataMapper")
    private QcDataMapper qcDataMapper;

    @Override
    public List<QcData> listByDate(String date) {
        return qcDataMapper.listByDate(date);
    }
}
