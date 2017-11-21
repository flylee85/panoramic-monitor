package com.monitor.web.controller.productionmonitoring;

import com.cloud.api.vo.ResultCode;
import com.monitor.api.productionmonitoring.PanoramicProductionMonitoringService;
import com.monitor.model.productionmonitoring.PanoramicProductionMonitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * @author summer
 * 2017/11/21.
 */
@RestController
@RequestMapping("/production/monitoring")
public class PanoramicProductionMonitoringController {
    @Autowired
    @Qualifier("panoramicProductionMonitoringService")
    private PanoramicProductionMonitoringService panoramicProductionMonitoringService;

    @PostMapping("/{id}")
    public ResultCode<PanoramicProductionMonitoring> add(PanoramicProductionMonitoring panoramicProductionMonitoring) {
        panoramicProductionMonitoringService.save(panoramicProductionMonitoring);
        return ResultCode.getSuccessReturn(panoramicProductionMonitoring);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicProductionMonitoring> update(PanoramicProductionMonitoring panoramicProductionMonitoring) {
        panoramicProductionMonitoringService.update(panoramicProductionMonitoring);
        return ResultCode.getSuccessReturn(panoramicProductionMonitoring);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicProductionMonitoring> detail(@PathVariable Integer id) {
        PanoramicProductionMonitoring panoramicProductionMonitoring = panoramicProductionMonitoringService.findById(id);
        return ResultCode.getSuccessReturn(panoramicProductionMonitoring);
    }

//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicProductionMonitoring> list = panoramicProductionMonitoringService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
}
