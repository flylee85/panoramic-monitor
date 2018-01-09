package com.risk.warning.mapper;

import com.cloud.core.Mapper;
import com.risk.warning.model.PanoramicWarningData;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author summer
 */
@Repository("warningDataMapper")
public interface PanoramicWarningDataMapper extends Mapper<PanoramicWarningData> {

    @Select(" ${strquery} ")
    List<PanoramicWarningData> GetSourceData(@Param("strquery") String strquery);
    
    @Insert(" Insert into risk.panoramic_warning_data (EventName,StrEvent,EventValue,Status,Ctime,SourceID,WarnConfigurationID,Level) values (\'${EventName}\',\'${StrEvent}\',${EventValue},${Status},\'${Ctime}\',${SourceID},${WarnConfigurationID},${Level}) ")
    void AddWarningSource(@Param("EventName") String eventname,@Param("StrEvent") String strevent,@Param("EventValue") Double eventvalue,@Param("Status") Integer status,@Param("Ctime") Timestamp ctime,@Param("SourceID") Integer sourceid,@Param("WarnConfigurationID") Integer warnconfigurationid,@Param("Level") Integer level);
    
    /**
     * 提升未处理预警数据等级
     */
    @Update("update panoramic_warning_data set level = 2 where datediff(now(),ctime) > 0 and Status = 1")
    void UpdatewarningSourceLevel();
    

    @Select(" select  T1.ID, T1.EventName, T1.StrEvent, T1.EventValue, T1.Status, T1.Ctime, T1.Utime, T1.SourceID, T1.WarnConfigurationID, T1.Level ,T2.WarningName,T2.FactoryName,T2.SectionName,T2.DeviceName,T2.MaxValue,T2.MinValue from panoramic_warning_data T1 LEFT JOIN panoramic_system_configurationnew T2 ON T1.WarnConfigurationID = T2.ID where  T1.Status = 1 ")
    List<PanoramicWarningData> GetDealWarningData();
    
    @Update("update panoramic_warning_data set Status = ${Status} where ID=${ID}")
    void UpdatewarningSourceStatus(@Param("Status") Integer status,@Param("ID") Integer id);
    
}