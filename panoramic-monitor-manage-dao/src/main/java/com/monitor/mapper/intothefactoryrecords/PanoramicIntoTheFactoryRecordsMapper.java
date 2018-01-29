package com.monitor.mapper.intothefactoryrecords;

import com.cloud.core.Mapper;
import com.monitor.model.intothefactoryrecords.PanoramicIntoTheFactoryRecords;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.monitor.dto.intothefactoryrecords.PanoramicIntoTheFactoryDto;
/**
 * @author summer
 */
@Repository("intoTheFactoryRecordsMapper")
public interface PanoramicIntoTheFactoryRecordsMapper extends Mapper<PanoramicIntoTheFactoryRecords> {
	
	/**
	 * 获取出厂监控对象内容
	 * @param date
	 * @return
	 */
	List<PanoramicIntoTheFactoryDto> selectIntoFactoryList(@Param("date") String date);
}