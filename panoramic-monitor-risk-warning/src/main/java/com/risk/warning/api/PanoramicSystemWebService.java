/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.risk.warning.api;

import java.util.List;

import com.cloud.core.Service;
import com.risk.warning.model.PanoramicRiskForWebInfo;
import com.risk.warning.model.PanoramicWarningData;
/**
 * @author 
 */

public interface PanoramicSystemWebService extends Service<PanoramicWarningData> {
    
	
	/**
     * 根据时间查询根据时间获取预警信息一览异常信息
     *
     * @param startDate
     * @param endDate
     * @return
     */
	List<PanoramicRiskForWebInfo> getRiskListByDate(String startDate,String endDate);

}
