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
    
    /**
     * 生成本地报警日志
     */
    @Insert(" Insert into risk.panoramic_warning_data (EventName,StrEvent,EventValue,Status,Ctime,SourceID,WarnConfigurationID,Level,IsSendEmail) values (\'${EventName}\',\'${StrEvent}\',${EventValue},${Status},\'${Ctime}\',${SourceID},${WarnConfigurationID},${Level},0) ")
    void addWarningSource(@Param("EventName") String eventname,@Param("StrEvent") String strevent,@Param("EventValue") Double eventvalue,@Param("Status") Integer status,@Param("Ctime") Timestamp ctime,@Param("SourceID") Integer sourceid,@Param("WarnConfigurationID") Integer warnconfigurationid,@Param("Level") Integer level);
    
    /**
     * 提升未处理预警数据等级
     */
    @Update(" update panoramic_warning_data T1 left join panoramic_system_configurationnew T2 on T1.WarnConfigurationID = T2.ID set level = level + 1 where T1.Status = 1 and T2.MaxLevel > T1.Level AND TIMESTAMPDIFF(DAY,now(),T1.Ctime) >= T2.LevelUpTime ")
    void updatewarningSourceLevel();
    

    @Select(" select  T1.ID, T1.EventName, T1.StrEvent, T1.EventValue, T1.Status, T1.Ctime, T1.Utime, T1.SourceID, T1.WarnConfigurationID, T1.Level ,T2.WarningName,T2.FactoryName,T2.SectionName,T2.DeviceName,T2.MaxValue,T2.MinValue from panoramic_warning_data T1 LEFT JOIN panoramic_system_configurationnew T2 ON T1.WarnConfigurationID = T2.ID where  T1.Status = 1 ")
    List<PanoramicWarningData> getDealWarningData();
    
    //修改发送状态
    @Update("update panoramic_warning_data set IsSendEmail = 1 where ID=${ID}")
    void updatewarningSourceStatus(@Param("ID") Integer id);
    

    //自动完成不需要发送EMAIL的预警信息
    @Update(" update panoramic_warning_data T1 INNER JOIN panoramic_system_configurationnew T2 ON T1.WarnConfigurationID = T2.ID  set T1.Status = 2 ,Utime = Ctime where T1.Status = 1 and T1.WarnConfigurationID = ${WarnConfigurationID} ")
    void finishDataForNoSendEmail(@Param("WarnConfigurationID") Integer warnconfigurationid);
    
    
    //自动完成发送EMAIL预警信息
    @Update(" update panoramic_warning_data T1 INNER JOIN panoramic_system_configurationnew T2 ON T1.WarnConfigurationID = T2.ID set T1.Status = 2 ,Utime = now() where T1.Status = 1 and T1.WarnConfigurationID = ${WarnConfigurationID} and T1.Ctime <= now()")
    void finishDataForSendEmail(@Param("WarnConfigurationID") Integer warnconfigurationid);
    
    
}