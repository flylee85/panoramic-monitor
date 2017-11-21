package com.monitor.web.controller.productmaterials;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.productmaterials.PanoramicProductMaterialsService;
import com.monitor.model.productmaterials.PanoramicProductMaterials;
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
@RequestMapping("/product/materials")
public class PanoramicProductMaterialsController extends AbstractAnnotationController {
    @Autowired
    @Qualifier("panoramicProductMaterialsService")
    private PanoramicProductMaterialsService panoramicProductMaterialsService;

    @PostMapping
    public ResultCode<PanoramicProductMaterials> add(PanoramicProductMaterials panoramicProductMaterials) {
        panoramicProductMaterialsService.save(panoramicProductMaterials);
        return ResultCode.getSuccessReturn(panoramicProductMaterials);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicProductMaterials> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicProductMaterials> update(PanoramicProductMaterials panoramicProductMaterials) {
        panoramicProductMaterialsService.update(panoramicProductMaterials);
        return ResultCode.getSuccessReturn(panoramicProductMaterials);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicProductMaterials> detail(@PathVariable Integer id) {
        PanoramicProductMaterials panoramicProductMaterials = panoramicProductMaterialsService.findById(id);
        return ResultCode.getSuccessReturn(panoramicProductMaterials);
    }

//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicProductMaterials> list = panoramicProductMaterialsService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
}
