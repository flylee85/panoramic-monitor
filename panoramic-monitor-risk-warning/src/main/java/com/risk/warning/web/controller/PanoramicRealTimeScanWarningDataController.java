
/**
 * @author fgh
 *
 */
package com.risk.warning.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.vo.ResultCode;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.risk.warning.api.PanoramicSystemSqlqueryService;
import com.risk.warning.model.PanoramicSystemSqlquery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/risk/sqlquery")
public class PanoramicRealTimeScanWarningDataController{
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicRealTimeScanWarningDataController.class);
    @Autowired
    @Qualifier("panoramicSystemSqlqueryService")
    private PanoramicSystemSqlqueryService panoramicSystemSqlqueryService;
    
    @ApiOperation(value = "扫描预警数据", notes = "扫描预警数据")
    @PostMapping("/task")
    public ResultCode<PanoramicSystemSqlquery> Task() {
    	//DB_LOGGER.warn("<--异常出库异常信息状态定时任务汇总  开始-->");
    	DB_LOGGER.warn("SDFDS");
    	panoramicSystemSqlqueryService.regularlScanWarningData();
        //DB_LOGGER.warn("<--异常出库异常信息状态定时任务汇总  结束-->");
        return ResultCode.SUCCESS;
    }
}