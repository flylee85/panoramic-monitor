package com.risk.warning.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.cloud.core.Mapper;
import com.risk.warning.model.PanoramicWarningReceiver;

@Repository("warningReceiverMapper")
public interface PanoramicWarningReceiverMapper extends Mapper<PanoramicWarningReceiver> {

    @Select(" Select id,warning_configuration_id,user_id,user_name,email from panoramic_warning_receiver where warning_configuration_id = ${WarningConfigurationID} and level = ${Level} ")
    List<PanoramicWarningReceiver> getDataByWarningConfigurationID(@Param("WarningConfigurationID") Integer warningconfigurationid,@Param("Level") Integer level);
    
}