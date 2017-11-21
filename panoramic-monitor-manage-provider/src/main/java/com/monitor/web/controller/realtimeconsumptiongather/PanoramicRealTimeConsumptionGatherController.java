package com.monitor.web.controller.realtimeconsumptiongather;

import com.cloud.api.vo.ResultCode;
import com.monitor.api.realtimeconsumptiongather.PanoramicRealTimeConsumptionGatherService;
import com.monitor.model.realtimeconsumptiongather.PanoramicRealTimeConsumptionGather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
* @author  summer
* 2017/11/21.
*/
@RestController
@RequestMapping("/real/time/consumption/gather")
public class PanoramicRealTimeConsumptionGatherController {
   @Autowired
   @Qualifier("panoramicRealTimeConsumptionGatherService")
    private PanoramicRealTimeConsumptionGatherService panoramicRealTimeConsumptionGatherService;

    @PostMapping
    public ResultCode<PanoramicRealTimeConsumptionGather> add(PanoramicRealTimeConsumptionGather panoramicRealTimeConsumptionGather) {
        panoramicRealTimeConsumptionGatherService.save(panoramicRealTimeConsumptionGather);
        return ResultCode.getSuccessReturn(panoramicRealTimeConsumptionGather);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicRealTimeConsumptionGather> update(PanoramicRealTimeConsumptionGather panoramicRealTimeConsumptionGather) {
        panoramicRealTimeConsumptionGatherService.update(panoramicRealTimeConsumptionGather);
        return ResultCode.getSuccessReturn(panoramicRealTimeConsumptionGather);
    }
    @GetMapping("/{id}")
    public ResultCode<PanoramicRealTimeConsumptionGather> detail(@PathVariable Integer id) {
        PanoramicRealTimeConsumptionGather panoramicRealTimeConsumptionGather = panoramicRealTimeConsumptionGatherService.findById(id);
        return ResultCode.getSuccessReturn(panoramicRealTimeConsumptionGather);
    }

//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicRealTimeConsumptionGather> list = panoramicRealTimeConsumptionGatherService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
}
