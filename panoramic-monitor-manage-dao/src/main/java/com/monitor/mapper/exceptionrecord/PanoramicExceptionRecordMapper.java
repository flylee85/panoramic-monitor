package com.monitor.mapper.exceptionrecord;

import com.cloud.core.Mapper;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;
import org.springframework.stereotype.Repository;

/**
 * @author summer
 */
@Repository("exceptionRecordMapper")
public interface PanoramicExceptionRecordMapper extends Mapper<PanoramicExceptionRecord> {
}