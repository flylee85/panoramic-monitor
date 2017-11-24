package com.monitor.api.exceptionrecord;

import com.cloud.core.Service;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;

import java.util.List;


/** 异常信息
 * @author summer
 * 2017/11/21.
 */
public interface PanoramicExceptionRecordService extends Service<PanoramicExceptionRecord> {

    /** 根据category和时间 查询异常信息
     * @param category
     * @param date
     * @return
     */
    List<PanoramicExceptionRecord> listByCategory(String category,String date);

    /** 根据时间查询全部异常信息
     * @param date
     * @return
     */
    List<PanoramicExceptionRecord> queryAll(String date);
}
