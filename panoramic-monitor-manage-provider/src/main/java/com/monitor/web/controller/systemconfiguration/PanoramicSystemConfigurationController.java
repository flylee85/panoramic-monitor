package com.monitor.web.controller.systemconfiguration;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.systemconfiguration.PanoramicSystemConfigurationService;
import com.monitor.model.systemconfiguration.PanoramicSystemConfiguration;
import com.monitor.web.controller.base.AbstractAnnotationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author summer
 * 2017/11/21.
 */
@RestController
@RequestMapping("/system/configuration")
public class PanoramicSystemConfigurationController extends AbstractAnnotationController {
    @Autowired
    @Qualifier("panoramicSystemConfigurationService")
    private PanoramicSystemConfigurationService panoramicSystemConfigurationService;

    @PostMapping
    public ResultCode<PanoramicSystemConfiguration> add(PanoramicSystemConfiguration panoramicSystemConfiguration) {
        panoramicSystemConfigurationService.save(panoramicSystemConfiguration);
        return ResultCode.getSuccessReturn(panoramicSystemConfiguration);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicSystemConfiguration> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicSystemConfiguration> update(PanoramicSystemConfiguration panoramicSystemConfiguration) {
        panoramicSystemConfigurationService.update(panoramicSystemConfiguration);
        return ResultCode.getSuccessReturn(panoramicSystemConfiguration);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicSystemConfiguration> detail(@PathVariable Integer id) {
        PanoramicSystemConfiguration panoramicSystemConfiguration = panoramicSystemConfigurationService.findById(id);
        return ResultCode.getSuccessReturn(panoramicSystemConfiguration);
    }

//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicSystemConfiguration> list = panoramicSystemConfigurationService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
}
