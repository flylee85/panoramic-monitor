package com.monitor.mapper.exceptionrecord;

import com.cloud.core.Mapper;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author summer
 */
@Repository("exceptionRecordMapper")
public interface PanoramicExceptionRecordMapper extends Mapper<PanoramicExceptionRecord> {

    /**
     * @param category
     * @param date
     * @return
     */
    @Select("select * from panoramic_exception_record where alarm_item = #{category} and date_sub(#{date}, INTERVAL #{number} DAY) <= date(alarm_time)")
    List<PanoramicExceptionRecord> findMsgByDate(String category, String date,Integer number);
}