package com.monitor.web.controller.dailyinventorysummary;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.dailyinventorysummary.PanoramicDailyInventorySummaryService;
import com.monitor.model.dailyinventorysummary.PanoramicDailyInventorySummary;
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
@RequestMapping("/daily/inventory/summary")
public class PanoramicDailyInventorySummaryController extends AbstractAnnotationController {
    @Autowired
    @Qualifier("panoramicDailyInventorySummaryService")
    private PanoramicDailyInventorySummaryService panoramicDailyInventorySummaryService;

    @PostMapping
    public ResultCode<PanoramicDailyInventorySummary> add(PanoramicDailyInventorySummary panoramicDailyInventorySummary) {
        panoramicDailyInventorySummaryService.save(panoramicDailyInventorySummary);
        return ResultCode.getSuccessReturn(panoramicDailyInventorySummary);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicDailyInventorySummary> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicDailyInventorySummary> update(PanoramicDailyInventorySummary panoramicDailyInventorySummary) {
        panoramicDailyInventorySummaryService.update(panoramicDailyInventorySummary);
        return ResultCode.getSuccessReturn(panoramicDailyInventorySummary);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicDailyInventorySummary> detail(@PathVariable Integer id) {
        PanoramicDailyInventorySummary panoramicDailyInventorySummary = panoramicDailyInventorySummaryService.findById(id);
        return ResultCode.getSuccessReturn(panoramicDailyInventorySummary);
    }

//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicDailyInventorySummary> list = panoramicDailyInventorySummaryService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
}
