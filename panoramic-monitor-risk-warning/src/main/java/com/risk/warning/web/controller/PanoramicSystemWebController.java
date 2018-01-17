
/**
 * @author fgh
 *
 */
package com.risk.warning.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.vo.ResultCode;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.risk.warning.api.PanoramicSystemWebService;
import com.risk.warning.model.PanoramicRiskForWebInfo;
import com.risk.warning.model.PanoramicWarningData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/riskapi")
public class PanoramicSystemWebController{
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicRealTimeScanWarningDataController.class);

    @Autowired
    @Qualifier("panoramicSystemWebService")
    private PanoramicSystemWebService panoramicSystemWebService;
    
    @ApiOperation(value = "预警信息一览查询接口", notes = "分页查询所有预警信息一览")
    @GetMapping(value = {"/getrisklist/{startdate}/{enddate}/{page}/{size}/{status}/{name}" , "/getrisklist/{startdate}/{enddate}/{page}/{size}/{status}"})
    public ResultCode<PageInfo<PanoramicRiskForWebInfo>> getrisklist(@PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate, @PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("status") Integer status, @PathVariable(value ="name",required = false)  String name) {
    	DB_LOGGER.warn(name);
        PageHelper.startPage(page, size);
        List<PanoramicRiskForWebInfo> list = panoramicSystemWebService.getRiskListByDate(startdate + " 00:00:00", enddate + " 23:59:59",status,name);
        PageInfo<PanoramicRiskForWebInfo> pageInfo = new PageInfo<>(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
    
    
    @ApiOperation(value = "手动解除预警信息", notes = "手动解除预警信息")
    @PostMapping("/finishbymanual")
    public ResultCode<Boolean> finishDataByManual(@RequestParam(value="Responsiblecontent") String responsiblecontent, @RequestParam(value="Responsiblename") String responsiblename,@RequestParam(value="Id") Integer id) {
    	Boolean result = panoramicSystemWebService.finishDataByManual(responsiblecontent,responsiblename,id);
        return ResultCode.getSuccessReturn(result);
    }
    

    
    
    @ApiOperation(value = "获取所有责任人", notes = "获取所有责任人")
    @GetMapping("/getresponsiblenameList")
    public ResultCode<List<String>> getResponsibleNameList() {
    	List<String> list = panoramicSystemWebService.getResponsibleNameList();
        return ResultCode.getSuccessReturn(list);
    }
    
}