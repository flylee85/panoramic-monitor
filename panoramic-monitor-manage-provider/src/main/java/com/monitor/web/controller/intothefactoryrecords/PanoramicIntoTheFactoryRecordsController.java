package com.monitor.web.controller.intothefactoryrecords;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.intothefactoryrecords.PanoramicIntoTheFactoryRecordsService;
import com.monitor.model.intothefactoryrecords.PanoramicIntoTheFactoryRecords;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author summer
 * 2017/11/29
 */
@Api
@RestController
@RequestMapping("/into/the/factory/records")
public class PanoramicIntoTheFactoryRecordsController {
    @Autowired
    @Qualifier("intoTheFactoryRecordsService")
    private PanoramicIntoTheFactoryRecordsService intoTheFactoryRecordsService;

    @PostMapping("/{id}")
    public ResultCode<PanoramicIntoTheFactoryRecords> add(PanoramicIntoTheFactoryRecords panoramicIntoTheFactoryRecords) {
        intoTheFactoryRecordsService.save(panoramicIntoTheFactoryRecords);
        return ResultCode.getSuccessReturn(panoramicIntoTheFactoryRecords);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicIntoTheFactoryRecords> update(PanoramicIntoTheFactoryRecords panoramicIntoTheFactoryRecords) {
        intoTheFactoryRecordsService.update(panoramicIntoTheFactoryRecords);
        return ResultCode.getSuccessReturn(panoramicIntoTheFactoryRecords);
    }

    @ApiOperation(value = "异常出厂信息查询接口", notes = "查询指定时间的最新一条异常出厂信息")
    @GetMapping("/{date}")
    public ResultCode<PanoramicIntoTheFactoryRecords> detail(@PathVariable("date") String date) {
        PanoramicIntoTheFactoryRecords records = intoTheFactoryRecordsService.findByDate(date);
        return ResultCode.getSuccessReturn(records);
    }

    @ApiOperation(value = "异常出厂信息查询接口", notes = "查询指定时间的异常出库次数")
    @GetMapping("/count/{date}")
    public ResultCode<Integer> count(@PathVariable("date") String date) {
        Integer records = intoTheFactoryRecordsService.count(date);
        return ResultCode.getSuccessReturn(records);
    }

    @ApiOperation(value = "异常出厂信息查询接口", notes = "分页查询所有异常出厂信息")
    @GetMapping("/{date}/{page}/{size}")
    public ResultCode<PageInfo<PanoramicIntoTheFactoryRecords>> listByDate(@PathVariable("date") String date, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicIntoTheFactoryRecords> list = intoTheFactoryRecordsService.listByDate(date);
        PageInfo<PanoramicIntoTheFactoryRecords> pageInfo = new PageInfo<>(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}