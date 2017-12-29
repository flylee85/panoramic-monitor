package com.monitor.mapper.dataverification;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.cloud.core.Mapper;
import com.monitor.model.dataverification.PanoramicDataVerification;

/**
 * @author summer
 */
@Repository("dataVerificationMapper")
public interface PanoramicDataVerificationMapper extends Mapper<PanoramicDataVerification> {
	
	/**
	 * 本月累计消耗量
	 * @param date
	 * @return
	 */
	@Select("SELECT " + 
			"	sum(value_auto) " + 
			"FROM " + 
			"	panoramic_data_verification " + 
			"WHERE " + 
			"	name LIKE \'磷矿粉%\' " + 
			"AND DATE_FORMAT(date , \"%Y-%m-%d\") BETWEEN DATE_ADD( " + 
			"	#{date} , " + 
			"	INTERVAL - DAY(#{date}) + 1 DAY " + 
			") " + 
			"AND #{date}")
	Double findThisMonthAutoSummary(@Param("date") String date);

	/**
	 * 本月累计出库量
	 * @param date
	 * @return
	 */
	@Select("SELECT " + 
			"	sum(value_manual) " + 
			"FROM " + 
			"	panoramic_data_verification " + 
			"WHERE " + 
			"	NAME LIKE \'磷矿粉%\' " + 
			"AND DATE_FORMAT(date , \"%Y-%m-%d\") BETWEEN DATE_ADD( " + 
			"	#{date} , " + 
			"	INTERVAL - DAY(#{date}) + 1 DAY " + 
			") " + 
			"AND #{date}")
	Double findThisMonthManualSummary(@Param("date") String date);

	/**
	 * 上月累计消耗量
	 * @param date
	 * @return
	 */
	@Select("SELECT " + 
			"	sum(value_auto) " + 
			"FROM " + 
			"	panoramic_data_verification " + 
			"WHERE " + 
			"	NAME LIKE \'磷矿粉%\' " + 
			"AND DATE_FORMAT(date , '%Y-%m') = date_format( " + 
			"	DATE_SUB(#{date} , INTERVAL 1 MONTH) , " + 
			"	'%Y-%m' " + 
			")")
	Double findLastMonthAutoSummary(@Param("date") String date);
	
	/**
	 * 上月累计生产量
	 * @param date
	 * @return
	 */
	@Select("SELECT " + 
			"	sum(value_manual) " + 
			"FROM " + 
			"	panoramic_data_verification " + 
			"WHERE " + 
			"	NAME LIKE \'磷矿粉%\' " + 
			"AND DATE_FORMAT(date , '%Y-%m') = date_format( " + 
			"	DATE_SUB(#{date} , INTERVAL 1 MONTH) , " + 
			"	'%Y-%m' " + 
			")")
	Double findLastMonthManualSummary(@Param("date") String date);
}