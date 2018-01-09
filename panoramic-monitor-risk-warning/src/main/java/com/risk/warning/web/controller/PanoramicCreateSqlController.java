package com.risk.warning.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.vo.ResultCode;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemConfigurationnewService;
import com.risk.warning.api.PanoramicWarningReceiverService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/create/sql")
public class PanoramicCreateSqlController{
	 private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicCreateSqlController.class);
    @Autowired
    @Qualifier("panoramicSystemConfigurationnewService")
    private PanoramicSystemConfigurationnewService panoramicSystemConfigurationnewService;
    
    @ApiOperation(value = "生成SQL文", notes = "生成SQL文")
    @PostMapping("/task")
    public ResultCode<Void> task() {
    	DB_LOGGER.warn("<--生成SQL文  开始-->");
    	panoramicSystemConfigurationnewService.createSqlService();
        DB_LOGGER.warn("<--生成SQL文  结束-->");
        return ResultCode.SUCCESS;
    }
}