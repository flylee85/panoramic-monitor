
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
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.vo.ResultCode;
import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.risk.warning.api.PanoramicSystemSqlqueryService;
import com.risk.warning.model.PanoramicWarningData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/riskapi")
public class PanoramicSystemWebController{
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicRealTimeScanWarningDataController.class);
    
    
    @ApiOperation(value = "预警信息一览查询接口", notes = "分页查询所有预警信息一览")
    @GetMapping("/{startdate}/{enddate} /{page}/{size}")
    public ResultCode<PageInfo<PanoramicWarningData>> getrisklist(@PathVariable("startdate") String startdate, @PathVariable("enddate") String enddate, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicWarningData> list = null;
        PageInfo<PanoramicWarningData> pageInfo = new PageInfo<>(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}