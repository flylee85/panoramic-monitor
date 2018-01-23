
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
import com.risk.warning.api.PanoramicWarningReceiverService;
import com.risk.warning.dto.PanoramicSystemSqlqueryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/deal/warning/data")
public class PanoramicRealTimeDealWarningDataController{
	 private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicRealTimeDealWarningDataController.class);
    @Autowired
    @Qualifier("panoramicWarningReceiverService")
    private PanoramicWarningReceiverService panoramicWarningReceiverService;
    
    @ApiOperation(value = "处理预警数据", notes = "处理预警数据")
    @PostMapping("/task")
    public ResultCode<Void> task() {
    	DB_LOGGER.warn("<--处理预警数据  开始-->");
    	panoramicWarningReceiverService.regularlDealWarningData();
        DB_LOGGER.warn("<--处理预警数据  结束-->");
        return ResultCode.SUCCESS;
    }
}