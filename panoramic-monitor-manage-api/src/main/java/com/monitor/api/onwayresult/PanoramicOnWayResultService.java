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
	
	
	List<PanoramicOnWayResultDto> getOnWayResult(Integer currentstatus);
	
	Integer getOverDayCount();
}