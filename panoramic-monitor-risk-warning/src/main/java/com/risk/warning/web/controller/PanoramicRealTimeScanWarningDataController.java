
/**
 * @author fgh
 *
 */
package com.risk.warning.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.vo.ResultCode;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemSqlqueryService;
import com.risk.warning.dto.PanoramicSystemSqlqueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/scan/warning/data")
public class PanoramicRealTimeScanWarningDataController{
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicRealTimeScanWarningDataController.class);
    @Autowired
    @Qualifier("panoramicSystemSqlqueryService")
    private PanoramicSystemSqlqueryService panoramicSystemSqlqueryService;
    
    @ApiOperation(value = "扫描预警数据", notes = "扫描预警数据")
    @PostMapping("/task")
    public ResultCode<Void> Task() {
    	DB_LOGGER.warn("<--预警数据扫描  开始-->");
    	panoramicSystemSqlqueryService.realTimeScanWarningDataTask();
        DB_LOGGER.warn("<--预警数据扫描 结束-->");
        return ResultCode.SUCCESS;
    }
}