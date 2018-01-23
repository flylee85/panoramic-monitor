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
import com.risk.warning.dto.PanoramicEmailSendInfoDto;
import com.risk.warning.dto.PanoramicRiskForWebInfoDto;
import com.risk.warning.dto.PanoramicWarningDataDto;
/**
 * @author 
 */

public interface PanoramicSystemWebService extends Service<PanoramicWarningDataDto> {
    
	
	/**
     * 根据时间查询根据时间获取预警信息一览异常信息
     *
     * @param startDate
     * @param endDate
     * @return
     */
	List<PanoramicRiskForWebInfoDto> getRiskListByDate(String startDate,String endDate,Integer status, String name);
	
	/**
     * 手动解除预警信息
     *
     * @param responsiblecontent
     * @param responsiblename
     * @param id
     * @return
     */
	Boolean finishDataByManual(String responsiblecontent,String responsiblename,Integer id);
	
	/**
     * 获取所有责任人
     *
     * @return
     */
	List<String> getResponsibleNameList();

}
