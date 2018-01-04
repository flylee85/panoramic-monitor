
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
import com.risk.warning.api.PanoramicWarningReceiverService;
import com.risk.warning.model.PanoramicSystemSqlquery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/risk/sendEmail")
public class PanoramicWarningReceiverController{
    @Autowired
    @Qualifier("panoramicWarningReceiverService")
    private PanoramicWarningReceiverService panoramicWarningReceiverService;
    
    @ApiOperation(value = "处理预警数据", notes = "处理预警数据")
    @PostMapping("/task")
    public ResultCode<PanoramicSystemSqlquery> task() {
    	//DB_LOGGER.warn("<--异常出库异常信息状态定时任务汇总  开始-->");
    	panoramicWarningReceiverService.regularlDealWarningData();
        //DB_LOGGER.warn("<--异常出库异常信息状态定时任务汇总  结束-->");
        return ResultCode.SUCCESS;
    }

}