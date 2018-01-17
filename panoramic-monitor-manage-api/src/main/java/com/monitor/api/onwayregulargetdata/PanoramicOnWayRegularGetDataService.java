/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.api.onwayregulargetdata;

import java.util.List;

import com.cloud.core.Service;
import com.monitor.dto.onwayqueryorder.PanoramicOnWayQueryOrderDto;

public interface PanoramicOnWayRegularGetDataService extends Service<PanoramicOnWayQueryOrderDto> {
	
	 /**
     * 获取新订单数据
     */
	void getNewOrderData();
	
}