/**
 * 
 */
/**
 * @author fgh
 *
 */
package com.monitor.web.controller.onwayweb;

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
import com.monitor.api.onwaydevice.PanoramicOnWayDeviceService;
import com.monitor.api.onwayresult.PanoramicOnWayResultService;
import com.monitor.dto.onwayresult.PanoramicOnWayResultDto;
import com.monitor.dto.onwaytitleresult.PanoramicOnWayTitleResultDto;
import com.monitor.model.onwaydevice.PanoramicOnWayDevice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/onway")
public class PanoramicOnWayWebController{
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(PanoramicOnWayWebController.class);

    @Autowired
    @Qualifier("onWayResultService")
    private PanoramicOnWayResultService onWayResultService;
    @Autowired
    @Qualifier("onWayDeviceService")
    private PanoramicOnWayDeviceService onWayDeviceService;
    
    @ApiOperation(value = "分页查询所有物资", notes = "分页查询所有物资")
    @GetMapping(value = {"/getOnWayResult/{currentstatus}/{page}/{size}"})
    public ResultCode<PageInfo<PanoramicOnWayResultDto>> getOnWayResult(@PathVariable("currentstatus") Integer currentstatus,@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicOnWayResultDto> list = onWayResultService.getOnWayResult(currentstatus);
        PageInfo<PanoramicOnWayResultDto> pageInfo = new PageInfo<>(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
    

    
    
    @ApiOperation(value = "获取标头信息", notes = "获取标头信息")
    @GetMapping("/getTitleInfo")
    public ResultCode<PanoramicOnWayTitleResultDto> getTitleInfo() {
    	PanoramicOnWayTitleResultDto record = new PanoramicOnWayTitleResultDto();
    	record.setAllCount(onWayDeviceService.getDeviceCount());
    	record.setBindCount(onWayDeviceService.getBindCount());
    	record.setOverDayCount(onWayResultService.getOverDayCount());
    	return ResultCode.getSuccessReturn(record);
    }
    
}