package com.monitor.api.dataverification;
import com.monitor.dto.dataverification.PanoramicDataVerificationDto;
import com.monitor.model.dataverification.PanoramicDataVerification;
import com.cloud.core.Service;


/**
*xuegang
* 2017/12/27.
*/
public interface PanoramicDataVerificationService extends Service<PanoramicDataVerification> {

	/**
	 * 指定时间查询本月度偏差值
	 * @param date
	 * @return
	 */
	PanoramicDataVerificationDto findThisMonthBiosByDate(String date);
	
	/**
	 * 指定时间查询上月度偏差值
	 * @param date
	 * @return
	 */
	PanoramicDataVerificationDto findLastMonthBiosByDate(String date);
}
