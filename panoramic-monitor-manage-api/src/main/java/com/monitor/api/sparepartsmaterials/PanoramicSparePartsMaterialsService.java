package com.monitor.api.sparepartsmaterials;

import java.util.List;

import com.cloud.core.Service;
import com.monitor.model.sparepartsmaterials.PanoramicSparePartsMaterials;


/**
* @author xuegang
* 2018/01/08.
*/
public interface PanoramicSparePartsMaterialsService extends Service<PanoramicSparePartsMaterials> {
	
	/**
	 * 获取当日库存货值
	 * @param date
	 * @return
	 */
	PanoramicSparePartsMaterials getSummaryByDate(String date);
	
	/**
	 * 获取当日前10位库存货值内容
	 * @param date
	 * @return
	 */
	List<PanoramicSparePartsMaterials> listSummaryByDate(String date);

}
