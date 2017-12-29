package com.monitor.web.controller.dataverification;

import com.cloud.api.vo.ResultCode;
import com.monitor.api.dataverification.PanoramicDataVerificationService;
import com.monitor.dto.dataverification.PanoramicDataVerificationDto;
import com.monitor.model.dataverification.PanoramicDataVerification;
import com.monitor.service.dataverification.PanoramicDataVerificationServiceImpl;

import com.monitor.web.controller.base.AbstractAnnotationController;
import io.swagger.annotations.ApiOperation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
*@author xuegang
* 2017/12/27.
*/
@RestController
@RequestMapping("/panoramic/data/verification")
public class PanoramicDataVerificationController extends AbstractAnnotationController {
   @Autowired
    @Qualifier("panoramicDataVerificationService")
    private PanoramicDataVerificationService panoramicDataVerificationService;

    @PostMapping
    public ResultCode<PanoramicDataVerification> add(PanoramicDataVerification panoramicDataVerification) {
        panoramicDataVerificationService.save(panoramicDataVerification);
        return ResultCode.getSuccessReturn(panoramicDataVerification);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicDataVerification> delete(@PathVariable Integer id) {
    		return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicDataVerification> update(PanoramicDataVerification panoramicDataVerification) {
        panoramicDataVerificationService.update(panoramicDataVerification);
        return ResultCode.getSuccessReturn(panoramicDataVerification);
    }
    @GetMapping("/{id}")
    public ResultCode<PanoramicDataVerification> detail(@PathVariable Integer id) {
        PanoramicDataVerification panoramicDataVerification = panoramicDataVerificationService.findById(id);
        return ResultCode.getSuccessReturn(panoramicDataVerification);
    }

    @GetMapping
    public ResultCode<List<PanoramicDataVerification>> list(Integer page, Integer size) {
        List<PanoramicDataVerification> list = panoramicDataVerificationService.findAll();
        return ResultCode.getSuccessReturn(list);
    }
    
    @ApiOperation(value = "当前月度偏差查询", notes = "根据时间查询当前月度偏差值")
    @GetMapping("/thismonthbios/{date}")
    public ResultCode<PanoramicDataVerificationDto> thismonthbios(@PathVariable String date) {
    		PanoramicDataVerificationDto result = panoramicDataVerificationService.findLastMonthBiosByDate(date);
        return ResultCode.getSuccessReturn(result);
    }
    
    @ApiOperation(value = "上月度偏差查询", notes = "根据时间查询上月度偏差值")
    @GetMapping("/lastmonthbios/{date}")
    public ResultCode<PanoramicDataVerificationDto> lastmonthbios(@PathVariable String date) {
    		PanoramicDataVerificationDto result = panoramicDataVerificationService.findLastMonthBiosByDate(date);
        return ResultCode.getSuccessReturn(result);
    }
}
