package com.risk.warning.mapper;

import com.cloud.core.Mapper;
import com.risk.warning.model.PanoramicSystemSqlquery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author 
 */
@Repository("systemSqlqueryMapper")
public interface PanoramicSystemSqlqueryMapper extends Mapper<PanoramicSystemSqlquery> {

    @Select(" select WarnConfigurationID,QuerySql,IntervalTime,LastExcuteTime from panoramic_system_sqlquery where Available = 1 and  date_add(LastExcuteTime, interval IntervalTime minute) < now() ")
    List<PanoramicSystemSqlquery> GetStrSqlQuery();
    
    @Update(" update panoramic_system_sqlquery set LastExcuteTime = now() where WarnConfigurationID = ${WarningConfigurationID} ")
    void UpdateLastexcuteTime(@Param("WarningConfigurationID") Integer warningconfigurationid);
}