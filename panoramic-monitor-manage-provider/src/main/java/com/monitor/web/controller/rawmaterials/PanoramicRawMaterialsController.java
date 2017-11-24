package com.monitor.web.controller.rawmaterials;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.rawmaterials.PanoramicRawMaterialsService;
import com.monitor.model.rawmaterials.PanoramicRawMaterials;
import com.monitor.web.controller.base.AbstractAnnotationController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author summer
 * 2017/11/21.
 */
@Api
@RestController
@RequestMapping("/raw/materials")
public class PanoramicRawMaterialsController extends AbstractAnnotationController {
    @Autowired
    @Qualifier("rawMaterialsService")
    private PanoramicRawMaterialsService rawMaterialsService;

    @PostMapping
    public ResultCode<PanoramicRawMaterials> add(PanoramicRawMaterials panoramicRawMaterials) {
        rawMaterialsService.save(panoramicRawMaterials);
        return ResultCode.getSuccessReturn(panoramicRawMaterials);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicRawMaterials> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicRawMaterials> update(PanoramicRawMaterials panoramicRawMaterials) {
        rawMaterialsService.update(panoramicRawMaterials);
        return ResultCode.getSuccessReturn(panoramicRawMaterials);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicRawMaterials> detail(@PathVariable Integer id) {
        PanoramicRawMaterials panoramicRawMaterials = rawMaterialsService.findById(id);
        return ResultCode.getSuccessReturn(panoramicRawMaterials);
    }

    @GetMapping("/{date}/{page}/{size}")
    public ResultCode<PageInfo> list(@PathVariable String date, @PathVariable Integer page, @PathVariable Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicRawMaterials> list = rawMaterialsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}
