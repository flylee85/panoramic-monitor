package com.monitor.service.exceptionrecord;

import com.cloud.core.AbstractService;
import com.monitor.api.exceptionrecord.PanoramicExceptionRecordService;
import com.monitor.mapper.exceptionrecord.PanoramicExceptionRecordMapper;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author summer
 * 2017/11/21.
 */
@Service("panoramicExceptionRecordService")
@Transactional
public class PanoramicExceptionRecordServiceImpl extends AbstractService<PanoramicExceptionRecord> implements PanoramicExceptionRecordService {
    @Autowired
    @Qualifier("panoramicExceptionRecordMapper")
    private PanoramicExceptionRecordMapper panoramicExceptionRecordMapper;

}
