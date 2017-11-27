package com.monitor.web.controller.materialthresholdconfiguration;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.materialthresholdconfiguration.PanoramicMaterialThresholdConfigurationService;
import com.monitor.model.materialthresholdconfiguration.PanoramicMaterialThresholdConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author summer
 * 2017/11/27
 */
@RestController
@RequestMapping("/panoramic/material/threshold/configuration")
public class PanoramicMaterialThresholdConfigurationController {
    @Autowired
    @Qualifier("materialThresholdConfigurationService")
    private PanoramicMaterialThresholdConfigurationService materialThresholdConfigurationService;

    @PostMapping("/{id}")
    public ResultCode<PanoramicMaterialThresholdConfiguration> add(PanoramicMaterialThresholdConfiguration panoramicMaterialThresholdConfiguration) {
        materialThresholdConfigurationService.save(panoramicMaterialThresholdConfiguration);
        return ResultCode.getSuccessReturn(panoramicMaterialThresholdConfiguration);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicMaterialThresholdConfiguration> update(PanoramicMaterialThresholdConfiguration panoramicMaterialThresholdConfiguration) {
        materialThresholdConfigurationService.update(panoramicMaterialThresholdConfiguration);
        return ResultCode.getSuccessReturn(panoramicMaterialThresholdConfiguration);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicMaterialThresholdConfiguration> detail(@PathVariable Integer id) {
        PanoramicMaterialThresholdConfiguration panoramicMaterialThresholdConfiguration = materialThresholdConfigurationService.findById(id);
        return ResultCode.getSuccessReturn(panoramicMaterialThresholdConfiguration);
    }

    @GetMapping
    public ResultCode<PageInfo> list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicMaterialThresholdConfiguration> list = materialThresholdConfigurationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}
