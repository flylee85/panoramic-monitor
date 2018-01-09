package com.risk.warning.mapper;

import com.cloud.core.Mapper;
import com.risk.warning.model.PanoramicSystemSqlquery;

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
public interface PanoramicSystemSqlqueryMapper extends Mapper<PanoramicSystemSqlquery> {

    @Select(" select warn_configuration_id,query_sql,interval_time,last_excute_time from panoramic_system_sqlquery where Available = 1 and  date_add(last_excute_time, interval interval_time minute) < now() ")
    List<PanoramicSystemSqlquery> getStrSqlQuery();
    
    @Update(" update panoramic_system_sqlquery set last_excute_time = now() where warn_configuration_id = ${WarningConfigurationID} ")
    void updateLastexcuteTime(@Param("WarningConfigurationID") Integer warningconfigurationid);
    
    @Insert(" insert into risk.panoramic_system_sqlquery (warn_configuration_id, query_sql, available, interval_time, last_excute_time) values(${WarnConfigurationID}, \'${QuerySql}\',1,${IntervalTime}, date_add(now(), interval ${IntervalTime} *-1  minute));")
    void addStrSqlQuery(@Param("WarnConfigurationID") Integer warnconfigurationid,@Param("QuerySql") String querysql,@Param("IntervalTime") Integer intervaltime);
    
    @Select("truncate table panoramic_system_sqlquery")
    void truncateTable();
}