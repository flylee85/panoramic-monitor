/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.risk.warning.api;


import com.cloud.core.Service;
import com.risk.warning.model.PanoramicWarningReceiver;

import java.util.List;


/**
 * @author 
 */

public interface PanoramicWarningReceiverService extends Service<PanoramicWarningReceiver> {
    
    /**
     * 定时任务 -对预警数据进行处理
     */
    void regularlDealWarningData();

}
