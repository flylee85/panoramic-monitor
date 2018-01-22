package com.monitor.api.realtimeconsumption;

import com.cloud.core.Service;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;
import java.util.List;



/**
 * @author summer
 * 2017/11/21.
 */
public interface PanoramicRealTimeConsumptionService extends Service<PanoramicRealTimeConsumption> {

    /**
     * 汇总指定code和date的消耗数据到汇总表中(定时任务)
     *
     * @param name
     * @param code
     * @param dateBefore
     * @param dateEnd
     */
	void realtimeConsumptionSummaryTask(String name, String code, String dateBefore, String dateEnd);

    /** 查询所有消耗分类(定时任务)
     * @return
     */
    List<PanoramicRealTimeConsumption> listRealTimeConsumptionCategoryTask();
    
    /**
     * 消耗数据定时任务汇总
     * @return
     */
	void realTimeConsumptionSummaryTask();
	
	/**
	 * 历史消耗数据补足
	 * @param dateFrom
	 * @param dateEnd
	 */
	void historyConsumptionSummaryTask(String dateFrom, String dateEnd);
    
}
