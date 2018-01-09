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
    @Insert(" Insert into risk.panoramic_warning_data (factory_name,section_name,device_name,event_name,str_event,event_value,status,ctime,source_id,warn_configuration_id,level,is_send_email) values (\'${FactoryName}\',\'${SectionName}\',\'${DeviceName}\',\'${EventName}\',\'${StrEvent}\',${EventValue},${Status},\'${Ctime}\',${SourceID},${WarnConfigurationID},${Level},false) ")
    void addWarningSource(@Param("FactoryName") String factoryame,@Param("SectionName") String sectioname,@Param("DeviceName") String devicename,@Param("EventName") String eventname,@Param("StrEvent") String strevent,@Param("EventValue") Double eventvalue,@Param("Status") Integer status,@Param("Ctime") Timestamp ctime,@Param("SourceID") Integer sourceid,@Param("WarnConfigurationID") Integer warnconfigurationid,@Param("Level") Integer level);
    
    /**
     * 提升未处理预警数据等级
     */
    @Update(" update panoramic_warning_data T1 left join panoramic_system_configurationnew T2 on T1.warn_configuration_id = T2.id set level = level + 1 where T1.status = 1 and T2.max_level > T1.Level AND TIMESTAMPDIFF(DAY,now(),T1.ctime) >= T2.level_up_Time ")
    void updatewarningSourceLevel();
    

    @Select(" select  T1.ID, T1.event_name, T1.str_event, T1.event_name, T1.status, T1.ctime, T1.utime, T1.source_id, T1.warn_configuration_id, T1.level ,T2.warning_name,T1.factory_name,T1.section_name,T1.device_name,T2.max_value,T2.min_value,T1.event_value from panoramic_warning_data T1 LEFT JOIN panoramic_system_configurationnew T2 ON T1.warn_configuration_id = T2.id where  T1.status = 1 ")
    List<PanoramicWarningData> getDealWarningData();
    
    //修改发送状态
    @Update("update panoramic_warning_data set is_send_email = true where ID=${ID}")
    void updatewarningSourceStatus(@Param("ID") Integer id);
    

    //自动完成不需要发送EMAIL的预警信息
    @Update(" update panoramic_warning_data T1 INNER JOIN panoramic_system_configurationnew T2 ON T1.warn_configuration_id = T2.id  set T1.status = 2 ,T1.utime = T1.ctime where T1.status = 1 and T1.warn_configuration_id = ${WarnConfigurationID} ")
    void finishDataForNoSendEmail(@Param("WarnConfigurationID") Integer warnconfigurationid);
    
    
    //自动完成发送EMAIL预警信息
    @Update(" update panoramic_warning_data T1 INNER JOIN panoramic_system_configurationnew T2 ON T1.warn_configuration_id = T2.id set T1.status = 2 ,T1.utime = now() where T1.status = 1 and T1.warn_configuration_id = ${WarnConfigurationID} and T1.ctime <= now()")
    void finishDataForSendEmail(@Param("WarnConfigurationID") Integer warnconfigurationid);
    
    
}