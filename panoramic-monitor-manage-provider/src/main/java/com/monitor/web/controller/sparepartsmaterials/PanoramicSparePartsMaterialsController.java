package com.monitor.web.controller.sparepartsmaterials;

import com.cloud.api.vo.ResultCode;
import com.monitor.api.sparepartsmaterials.PanoramicSparePartsMaterialsService;
import com.monitor.model.sparepartsmaterials.PanoramicSparePartsMaterials;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
* @author xuegang
* 2018/01/08.
*/
@RestController
@RequestMapping("/spare/parts/materials")
public class PanoramicSparePartsMaterialsController {
    @Autowired
    @Qualifier("sparePartsMaterialsService")
    private PanoramicSparePartsMaterialsService panoramicSparePartsMaterialsService;

    @PostMapping
    public ResultCode<PanoramicSparePartsMaterials> add(PanoramicSparePartsMaterials panoramicSparePartsMaterials) {
        panoramicSparePartsMaterialsService.save(panoramicSparePartsMaterials);
        return ResultCode.getSuccessReturn(panoramicSparePartsMaterials);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicSparePartsMaterials> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicSparePartsMaterials> update(PanoramicSparePartsMaterials panoramicSparePartsMaterials) {
        panoramicSparePartsMaterialsService.update(panoramicSparePartsMaterials);
        return ResultCode.getSuccessReturn(panoramicSparePartsMaterials);
    }
    @GetMapping("/{id}")
    public ResultCode<PanoramicSparePartsMaterials> detail(@PathVariable Integer id) {
        PanoramicSparePartsMaterials panoramicSparePartsMaterials = panoramicSparePartsMaterialsService.findById(id);
        return ResultCode.getSuccessReturn(panoramicSparePartsMaterials);
    }

    @GetMapping
    public ResultCode<List<PanoramicSparePartsMaterials>> list(Integer page, Integer size) {
        List<PanoramicSparePartsMaterials> list = panoramicSparePartsMaterialsService.findAll();
        return ResultCode.getSuccessReturn(list);
    }
    
    @ApiOperation(value = "当日库存总货值", notes = "仓库监管-备品备件库货值总量")
    @GetMapping("/summary/{date}")
    public ResultCode<PanoramicSparePartsMaterials> getSummaryByDate(@PathVariable("date") String date) {
        PanoramicSparePartsMaterials panoramicSparePartsMaterials = panoramicSparePartsMaterialsService.getSummaryByDate(date);
        return ResultCode.getSuccessReturn(panoramicSparePartsMaterials);
    } 
    
    @ApiOperation(value = "当日库存总货值", notes = "仓库监管-备品备件库货值总量")
    @GetMapping("/summary/detail/{date}")
    public ResultCode<List<PanoramicSparePartsMaterials>> listSummaryByDate(@PathVariable("date") String date) {
        List<PanoramicSparePartsMaterials> listPanoramicSparePartsMaterials = panoramicSparePartsMaterialsService.listSummaryByDate(date);
        return ResultCode.getSuccessReturn(listPanoramicSparePartsMaterials);
    }
    
    @ApiOperation(value = "当日高库存列表", notes = "仓库监管-备品备件库货值高库存列表")
    @GetMapping("/summary/high/detail/{date}")
    public ResultCode<List<PanoramicSparePartsMaterials>> listHighValueByDate(@PathVariable("date") String date) {
        List<PanoramicSparePartsMaterials> listPanoramicSparePartsMaterials = 
        		panoramicSparePartsMaterialsService.listHighValueByDate(date);
        return ResultCode.getSuccessReturn(listPanoramicSparePartsMaterials);
    }
    
    @ApiOperation(value = "当日低库存列表", notes = "仓库监管-备品备件库货值低库存列表")
    @GetMapping("/summary/low/detail/{date}")
    public ResultCode<List<PanoramicSparePartsMaterials>> listLowValueByDate(@PathVariable("date") String date) {
        List<PanoramicSparePartsMaterials> listPanoramicSparePartsMaterials = 
        		panoramicSparePartsMaterialsService.listLowValueByDate(date);
        return ResultCode.getSuccessReturn(listPanoramicSparePartsMaterials);
    }
}
