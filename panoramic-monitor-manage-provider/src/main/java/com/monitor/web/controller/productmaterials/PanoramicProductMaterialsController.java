package com.monitor.web.controller.productmaterials;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.productmaterials.PanoramicProductMaterialsService;
import com.monitor.model.productmaterials.PanoramicProductMaterials;
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
@RequestMapping("/product/materials")
public class PanoramicProductMaterialsController extends AbstractAnnotationController {
    @Autowired
    @Qualifier("productMaterialsService")
    private PanoramicProductMaterialsService productMaterialsService;

    @PostMapping
    public ResultCode<PanoramicProductMaterials> add(PanoramicProductMaterials panoramicProductMaterials) {
        productMaterialsService.save(panoramicProductMaterials);
        return ResultCode.getSuccessReturn(panoramicProductMaterials);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicProductMaterials> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicProductMaterials> update(PanoramicProductMaterials panoramicProductMaterials) {
        productMaterialsService.update(panoramicProductMaterials);
        return ResultCode.getSuccessReturn(panoramicProductMaterials);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicProductMaterials> detail(@PathVariable Integer id) {
        PanoramicProductMaterials panoramicProductMaterials = productMaterialsService.findById(id);
        return ResultCode.getSuccessReturn(panoramicProductMaterials);
    }

//    @GetMapping
//    public ResultCode<PageInfo> list(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<PanoramicProductMaterials> list = productMaterialsService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
}
