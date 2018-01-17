/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.api.onwaydevice;

import java.util.List;

import com.cloud.core.Service;
import com.monitor.dto.onwayqueryorder.PanoramicOnWayQueryOrderDto;
import com.monitor.model.onwaydevice.PanoramicOnWayDevice;

public interface PanoramicOnWayDeviceService extends Service<PanoramicOnWayDevice> {
	
	/**
	 * 获取全部设备
	 * @return
	 */
	List<PanoramicOnWayDevice> getDeviceList();
	
	
	/**
	 * 获取绑定的数据量
	 * @return
	 */
	Integer getBindCount();
	
}