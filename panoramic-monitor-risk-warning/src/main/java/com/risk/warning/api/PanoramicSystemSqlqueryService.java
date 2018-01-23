/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.risk.warning.api;


import com.cloud.core.Service;
import com.risk.warning.dto.PanoramicSystemSqlqueryDto;

import java.util.List;


/**
 * @author 
 */

public interface PanoramicSystemSqlqueryService extends Service<PanoramicSystemSqlqueryDto> {

    /**
     * 定时任务 -扫描预警数据
     */
    void realTimeScanWarningDataTask();
    

}
