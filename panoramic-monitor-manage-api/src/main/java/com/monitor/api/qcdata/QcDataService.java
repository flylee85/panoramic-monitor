package com.monitor.api.qcdata;

import com.cloud.core.Service;
import com.monitor.model.qcdata.QcData;

import java.util.List;


/**
 * @author summer
 * 2017/11/27
 */
public interface QcDataService extends Service<QcData> {

    /**根据时间指定查询质检数据
     * @param date
     * @return
     */
    List<QcData> listByDate(String date);
}
