package com.risk.warning.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.risk.warning.model.PanoramicWarningReceiver;

@Repository("warningReceiverMapper")
public interface PanoramicWarningReceiverMapper extends Mapper<PanoramicWarningReceiver> {

    @Select(" Select ID,WarningConfigurationID,UserID,UserName,Email from panoramic_warning_receiver where WarningConfigurationID = ${WarningConfigurationID} and Level = ${Level} ")
    List<PanoramicWarningReceiver> GetDataByWarningConfigurationID(@Param("WarningConfigurationID") Integer warningconfigurationid,@Param("Level") Integer level);
    
}