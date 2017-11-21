package com.monitor.web.controller.realtimeconsumption;

import com.cloud.api.vo.ResultCode;
import com.monitor.api.realtimeconsumption.PanoramicRealTimeConsumptionService;
import com.monitor.model.realtimeconsumption.PanoramicRealTimeConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
*@author summer
* 2017/11/21.
*/
@RestController
@RequestMapping("/real/time/consumption")
public class PanoramicRealTimeConsumptionController {
   @Autowired
   @Qualifier("panoramicRealTimeConsumptionService")
    private PanoramicRealTimeConsumptionService panoramicRealTimeConsumptionService;

    @PostMapping
    public ResultCode<PanoramicRealTimeConsumption> add(PanoramicRealTimeConsumption panoramicRealTimeConsumption) {
        panoramicRealTimeConsumptionService.save(panoramicRealTimeConsumption);
        return ResultCode.getSuccessReturn(panoramicRealTimeConsumption);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicRealTimeConsumption> update(PanoramicRealTimeConsumption panoramicRealTimeConsumption) {
        panoramicRealTimeConsumptionService.update(panoramicRealTimeConsumption);
        return ResultCode.getSuccessReturn(panoramicRealTimeConsumption);
    }
    @GetMapping("/{id}")
    public ResultCode<PanoramicRealTimeConsumption> detail(@PathVariable Integer id) {
        PanoramicRealTimeConsumption panoramicRealTimeConsumption = panoramicRealTimeConsumptionService.findById(id);
        return ResultCode.getSuccessReturn(panoramicRealTimeConsumption);
    }

//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicRealTimeConsumption> list = panoramicRealTimeConsumptionService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
}
