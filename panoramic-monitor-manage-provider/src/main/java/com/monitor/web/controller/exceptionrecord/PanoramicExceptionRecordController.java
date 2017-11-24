package com.monitor.web.controller.exceptionrecord;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.exceptionrecord.PanoramicExceptionRecordService;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;
import com.monitor.web.controller.base.AbstractAnnotationController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @author summer
 * 2017/11/21.
 */
@Api
@RestController
@RequestMapping("/exception/record")
public class PanoramicExceptionRecordController extends AbstractAnnotationController {
    @Autowired
    @Qualifier("exceptionRecordService")
    private PanoramicExceptionRecordService exceptionRecordService;

    @ApiOperation(value = "异常信息接口-获取异常详情", notes = "获取异常详情")
    @GetMapping("/{id}")
    public ResultCode<PanoramicExceptionRecord> detail(@PathVariable Integer id) {
        PanoramicExceptionRecord panoramicExceptionRecord = exceptionRecordService.findById(id);
        return ResultCode.getSuccessReturn(panoramicExceptionRecord);
    }

    @PostMapping
    public ResultCode<PanoramicExceptionRecord> add(PanoramicExceptionRecord panoramicExceptionRecord) {
        exceptionRecordService.save(panoramicExceptionRecord);
        return ResultCode.getSuccessReturn(panoramicExceptionRecord);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicExceptionRecord> update(PanoramicExceptionRecord panoramicExceptionRecord) {
        exceptionRecordService.update(panoramicExceptionRecord);
        return ResultCode.getSuccessReturn(panoramicExceptionRecord);
    }

    //
    @ApiOperation(value = "异常信息查询接口", notes = "分页查询所有异常信息")
    @GetMapping("/{date}/{page}/{size}")
    public ResultCode<PageInfo<PanoramicExceptionRecord>> list(@PathVariable String date,@PathVariable Integer page, @PathVariable Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicExceptionRecord> list = exceptionRecordService.queryAll(date);
        PageInfo<PanoramicExceptionRecord> pageInfo = new PageInfo<>(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }

    @ApiOperation(value = "异常信息查询接口", notes = "根据指定分类分页查询异常信息")
    @GetMapping("/{date}/{category}/{page}/{size}")
    public ResultCode<PageInfo<PanoramicExceptionRecord>> listByCategory(@PathVariable String date,@PathVariable String category, @PathVariable Integer page, @PathVariable Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicExceptionRecord> list = exceptionRecordService.listByCategory(category,date);
        PageInfo<PanoramicExceptionRecord> pageInfo = new PageInfo<>(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}
