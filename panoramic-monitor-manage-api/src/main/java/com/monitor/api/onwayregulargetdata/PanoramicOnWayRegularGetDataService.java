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
import com.monitor.dto.onwayqueryresult.PanoramicOnWayQueryResultOrderDto;

public interface PanoramicOnWayRegularGetDataService extends Service<PanoramicOnWayQueryResultOrderDto> {
	
	 /**
     * 获取新订单数据
     */
	void getNewOrderData();
	 /**
     * 更新未完成的订单数据
     */
	void updateOrderData();
	
	/**
     * 获取设备数据
     */
	void addDeviceData();
	
}