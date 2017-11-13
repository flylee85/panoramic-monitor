package com.invoke.web.controller.material;


import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.invoke.api.material.MaterialConsumptionService;
import com.invoke.model.dto.MaterialConsumptionDto;
import com.invoke.model.material.MaterialConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author sunder
 * 物料接口
 */
@RestController
@RequestMapping("/material/consumption")
public class MaterialConsumptionController {
    @Autowired
    @Qualifier("materialConsumptionService")
    private MaterialConsumptionService materialConsumptionService;

    @GetMapping("/{id}")
    public ResultCode<MaterialConsumption> detail(@PathVariable Integer id) {
        MaterialConsumption materialConsumption = materialConsumptionService.findById(id);
        return ResultCode.getSuccessReturn(materialConsumption);
    }

//    @GetMapping
//    public ResultCode<PageInfo> listAll(Integer page, Integer size) {
//        PageHelper.startPage(page, size);
//        List<MaterialConsumption> list = materialConsumptionService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultCode.getSuccessReturn(pageInfo);
//    }
//
//    @GetMapping
//    public ResultCode<List<MaterialConsumptionDto>> listByDate(String matCode, Date conTime) {
//        List<MaterialConsumptionDto> list = materialConsumptionService.listByDate(matCode, conTime);
//        return ResultCode.getSuccessReturn(list);
//    }

}
