package com.monitor.web.controller.exceptionrecord;

import com.cloud.api.vo.ResultCode;
import com.monitor.api.exceptionrecord.PanoramicExceptionRecordService;
import com.monitor.model.exceptionrecord.PanoramicExceptionRecord;

import com.monitor.web.controller.base.AbstractAnnotationController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author summer
 * 2017/11/21.
 */
@Api
@RestController
@RequestMapping("/exception/record")
public class PanoramicExceptionRecordController extends AbstractAnnotationController {
    @Autowired
    @Qualifier("panoramicExceptionRecordService")
    private PanoramicExceptionRecordService panoramicExceptionRecordService;
    
    @ApiOperation(value = "异常信息接口-获取异常详情", notes = "获取异常详情")
    @GetMapping("/{id}")
    public ResultCode<PanoramicExceptionRecord> detail(@PathVariable Integer id) {
        PanoramicExceptionRecord panoramicExceptionRecord = panoramicExceptionRecordService.findById(id);
        return ResultCode.getSuccessReturn(panoramicExceptionRecord);
    }

    @PostMapping
    public ResultCode<PanoramicExceptionRecord> add(PanoramicExceptionRecord panoramicExceptionRecord) {
        panoramicExceptionRecordService.save(panoramicExceptionRecord);
        return ResultCode.getSuccessReturn(panoramicExceptionRecord);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicExceptionRecord> update(PanoramicExceptionRecord panoramicExceptionRecord) {
        panoramicExceptionRecordService.update(panoramicExceptionRecord);
        return ResultCode.getSuccessReturn(panoramicExceptionRecord);
    }
//
//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicExceptionRecord> list = panoramicExceptionRecordService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
}
