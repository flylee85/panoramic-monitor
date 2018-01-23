package com.risk.warning.mapper;

import com.cloud.core.Mapper;
import com.risk.warning.dto.PanoramicSystemSqlqueryDto;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author 
 */
@Repository("systemSqlqueryMapper")
public interface PanoramicSystemSqlqueryMapper extends Mapper<PanoramicSystemSqlqueryDto> {

    @Select(" select T1.warn_configuration_id,T1.query_sql,T1.interval_time,T1.last_excute_time,T2.logic_type from panoramic_system_sqlquery T1 LEFT JOIN panoramic_system_configurationnew T2 ON T1.warn_configuration_id = T2.id where T1.Available = 1 and  date_add(T1.last_excute_time, interval T1.interval_time minute) < now() ")
    List<PanoramicSystemSqlqueryDto> getStrSqlQuery();
    
    @Update(" update panoramic_system_sqlquery set last_excute_time = now() where warn_configuration_id = ${WarningConfigurationID} ")
    void updateLastexcuteTime(@Param("WarningConfigurationID") Integer warningconfigurationid);
    
    @Insert(" insert into panoramic_system_sqlquery (warn_configuration_id, query_sql, available, interval_time, last_excute_time) values(${WarnConfigurationID}, \'${QuerySql}\',1,${IntervalTime}, date_add(now(), interval ${IntervalTime} *-1  minute));")
    void addStrSqlQuery(@Param("WarnConfigurationID") Integer warnconfigurationid,@Param("QuerySql") String querysql,@Param("IntervalTime") Integer intervaltime);
    
    @Select("truncate table panoramic_system_sqlquery")
    void truncateTable();
}