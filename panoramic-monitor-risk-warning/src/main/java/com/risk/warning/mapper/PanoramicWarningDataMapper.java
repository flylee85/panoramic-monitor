package com.risk.warning.mapper;

import com.cloud.core.Mapper;
import com.risk.warning.dto.PanoramicEmailSendInfoDto;
import com.risk.warning.dto.PanoramicRiskForWebInfoDto;
import com.risk.warning.dto.PanoramicWarningDataDto;

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
public interface PanoramicWarningDataMapper extends Mapper<PanoramicWarningDataDto> {

	 @Select(" ${strquery} \'${LastExcuteTime}\' ")
	 List<PanoramicWarningDataDto> GetSourceData(@Param("strquery") String strquery,@Param("LastExcuteTime") Timestamp lastexcutetime);
    /**
     * 生成本地报警日志
     */
    @Insert(" Insert into panoramic_warning_data (factory_name,section_name,device_name,event_name,str_event,event_value,status,ctime,source_id,warn_configuration_id,level,is_send_email) values (\'${FactoryName}\',\'${SectionName}\',\'${DeviceName}\',\'${EventName}\',\'${StrEvent}\',\'${EventValue}\',${Status},\'${Ctime}\',${SourceID},${WarnConfigurationID},${Level},${IsSendEmail}) ")
    void addWarningSource(@Param("FactoryName") String factoryame,@Param("SectionName") String sectioname,@Param("DeviceName") String devicename,@Param("EventName") String eventname,@Param("StrEvent") String strevent,@Param("EventValue") String eventvalue,@Param("Status") Integer status,@Param("Ctime") String ctime,@Param("SourceID") Integer sourceid,@Param("WarnConfigurationID") Integer warnconfigurationid,@Param("Level") Integer level,@Param("IsSendEmail") Boolean issendemail);
    
    /**
     * 提升未处理预警数据等级
     */
    @Update(" update panoramic_warning_data T1 left join panoramic_system_configurationnew T2 on T1.warn_configuration_id = T2.id set level = level + 1,T1.is_send_email = 0  where T1.status = 1 and T2.max_level > T1.Level AND TIMESTAMPDIFF(DAY,now(),T1.ctime) >= T2.level_up_Time ")
    void updatewarningSourceLevel();
    

    @Select(" select  T1.ID, T1.event_name, T1.str_event, T1.event_name, T1.status, T1.ctime, T1.utime, T1.source_id, T1.warn_configuration_id, T1.level ,T2.warning_name,T1.factory_name,T1.section_name,T1.device_name,T2.max_value,T2.min_value,T1.event_value,T2.logic_type from panoramic_warning_data T1 LEFT JOIN panoramic_system_configurationnew T2 ON T1.warn_configuration_id = T2.id where  T1.status = 1 and T1.is_send_email = 0 ")
    List<PanoramicWarningDataDto> getDealWarningData();
    
    //修改发送状态
    @Update("update panoramic_warning_data set is_send_email = true where ID=${ID}")
    void updatewarningSourceStatus(@Param("ID") Integer id);
    

    //自动完成不需要发送EMAIL的预警信息
    @Update(" UPDATE panoramic_warning_data T1 SET T1.status = 2 ,T1.utime = T1.ctime,T1.responsible_content = '自动解除预警',T1.responsible_name = '系统自动解除预警'  where T1.status = 1 and T1.warn_configuration_id = ${WarnConfigurationID} ")
    void finishDataForNoSendEmail(@Param("WarnConfigurationID") Integer warnconfigurationid);
    
    
    //自动完成发送EMAIL预警信息
    @Update("update panoramic_warning_data T1 set T1.status = 2 ,T1.utime = now(),T1.responsible_content = '系统自动解除预警',T1.responsible_name = '系统自动解除预警' where T1.status = 1 and T1.warn_configuration_id = ${WarnConfigurationID} and T1.ctime <= now()")
    void finishDataForSendEmail(@Param("WarnConfigurationID") Integer warnconfigurationid);
    
    //根据时间获取预警信息一览
    @Select(" select T1.id, case T1.status when 1 then '未解除' when 2 then '已解除' else '' end as status_name,T2.warning_name,concat(T1.factory_name,T1.section_name,T1.device_name,T1.event_name,'=',T1.event_value,' 超出阈值(',T2.min_value,',',T2.max_value,')') as warning_content,T1.ctime,T1.responsible_name as receiver_name,T1.responsible_content as return_content,T1.utime,T1.Level from panoramic_warning_data T1 left join panoramic_system_configurationnew T2 on T1.warn_configuration_id = T2.id where T1.ctime >= \'${StartDate}\' and T1.ctime <= \'${EndDate}\' ${strWhere}  order by T1.ctime desc ,T1.status desc")
    List<PanoramicRiskForWebInfoDto> getRiskListByDate(@Param("StartDate") String startdate,@Param("EndDate") String enddate,@Param("strWhere") String strWhere);
    
    
    //获取某一类型的报警数据库离的倒数几天
    @Select("Select T1.factory_name,T1.section_name,T1.device_name,T1.event_name,T1.str_event,T1.event_value,T1.status,T1.ctime as createtime,T1.source_id,T1.warn_configuration_id,T1.level,T1.is_send_email,T2.max_level,TIMESTAMPDIFF(day,T1.ctime,\'${lastTime}\') as day_count from panoramic_warning_data T1 left join panoramic_system_configurationnew T2 on T1.warn_configuration_id = T2.id where TIMESTAMPDIFF(day,T1.ctime,\'${lastTime}\') <= ${DataCount} and T1.status = 1 and T1.warn_configuration_id =  ${WarnConfigurationID} order by T1.ctime desc,T1.status desc")
    List<PanoramicWarningDataDto> getLastWarningDataByConfigurationID(@Param("DataCount") Integer daycount,@Param("WarnConfigurationID") Integer warnconfigurationid,@Param("lastTime") String lastTime);
    
    //手动解除预警数据
    @Update("update panoramic_warning_data set status = 2 ,utime = now(),responsible_content= \'${responsiblecontent}\',responsible_name= \'${responsiblename}\' where id = ${id} and status = 1")
    Boolean finishDataByManual(@Param("responsiblecontent") String responsiblecontent,@Param("responsiblename") String responsiblename,@Param("id") Integer id);
    
    @Select("Select distinct responsible_name from panoramic_warning_data where  responsible_name is not null ")
    List<String> getResponsibleNameList();
    
    
}