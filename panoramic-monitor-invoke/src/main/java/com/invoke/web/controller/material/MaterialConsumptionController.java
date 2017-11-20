package com.invoke.web.controller.material;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.invoke.api.material.MaterialConsumptionService;
import com.invoke.model.dto.MaterialConsumptionDto;
import com.invoke.model.material.MaterialConsumption;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author summer 物料接口
 */
@Api
@RestController
@RequestMapping("/material/consumption")
public class MaterialConsumptionController {
	@Autowired
	@Qualifier("materialConsumptionService")
	private MaterialConsumptionService materialConsumptionService;

	@ApiOperation(value = "测试接口-物料详情", notes = "获取物料详细信息")
	@GetMapping("/{id}")
	public ResultCode<MaterialConsumption> detail(@PathVariable Integer id) {
		MaterialConsumption materialConsumption = materialConsumptionService.findById(id);
		return ResultCode.getSuccessReturn(materialConsumption);
	}

	@ApiOperation(value = "测试接口-删除物料", notes = "根据id删除物料信息")
	@PostMapping("/{id}")
	public ResultCode<MaterialConsumption> post(@PathVariable Integer id) {
		// TODO 删除数据接口暂时不提供
		// materialConsumptionService.deleteById(id);
		return ResultCode.SUCCESS;
	}

	@ApiOperation(value = "测试接口-物料分页查询", notes = "获取物料分页查询")
	@GetMapping("/{page}/{size}")
	public ResultCode<PageInfo> listAll(@PathVariable Integer page, @PathVariable Integer size) {
		PageHelper.startPage(page, size);
		List<MaterialConsumption> list = materialConsumptionService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultCode.getSuccessReturn(pageInfo);
	}

	// @GetMapping("/{matCode}/{conTime}")
	// public ResultCode<List<MaterialConsumptionDto>> listByDate(@PathVariable
	// String matCode, @PathVariable String conTime) {
	// List<MaterialConsumptionDto> list =
	// materialConsumptionService.listByDate(matCode, conTime);
	// return ResultCode.getSuccessReturn(list);
	// }

}
