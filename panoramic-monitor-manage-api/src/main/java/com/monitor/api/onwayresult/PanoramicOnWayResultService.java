/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.api.onwayresult;

import java.util.List;

import com.cloud.core.Service;
import com.monitor.dto.onwayresult.PanoramicOnWayResultDto;

public interface PanoramicOnWayResultService extends Service<PanoramicOnWayResultDto> {
	
	 /**
     * 获取在途物资一览
     */
	List<PanoramicOnWayResultDto> getOnWayResult(Integer currentstatus);
	
	 /**
     * 获取在途超时物资数
     */
	Integer getOverDayCount();
}