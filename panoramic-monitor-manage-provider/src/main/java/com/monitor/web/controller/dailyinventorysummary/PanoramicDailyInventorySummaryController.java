package com.monitor.web.controller.dailyinventorysummary;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.dailyinventorysummary.PanoramicDailyInventorySummaryService;
import com.monitor.model.dailyinventorysummary.PanoramicDailyInventorySummary;
import com.monitor.web.controller.base.AbstractAnnotationController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author summer 2017/11/21.
 */
@Api
@RestController
@RequestMapping("/daily/inventory/summary")
public class PanoramicDailyInventorySummaryController extends AbstractAnnotationController {
	@Autowired
	@Qualifier("dailyInventorySummaryService")
	private PanoramicDailyInventorySummaryService dailyInventorySummaryService;

	/**
	 * 根据时间和物料编码查询库存
	 *
	 * @param code
	 * @param date
	 * @return
	 */
	@ApiOperation(value = "库存查询接口", notes = "根据时间和物料编码查询库存")
	@GetMapping("/{date}/{code}")
	public ResultCode<PanoramicDailyInventorySummary> queryByDateAndCode(@PathVariable String date,
			@PathVariable String code) {
		PanoramicDailyInventorySummary dailyInventorySummary = dailyInventorySummaryService
				.queryByDateAndCode(code, date);
		return ResultCode.getSuccessReturn(dailyInventorySummary);
	}

	@PostMapping
	public ResultCode<PanoramicDailyInventorySummary> add(
			PanoramicDailyInventorySummary panoramicDailyInventorySummary) {
		dailyInventorySummaryService.save(panoramicDailyInventorySummary);
		return ResultCode.getSuccessReturn(panoramicDailyInventorySummary);
	}

	@DeleteMapping("/{id}")
	public ResultCode<PanoramicDailyInventorySummary> delete(@PathVariable Integer id) {
		return ResultCode.SUCCESS;
	}

	@PutMapping
	public ResultCode<PanoramicDailyInventorySummary> update(
			PanoramicDailyInventorySummary panoramicDailyInventorySummary) {
		dailyInventorySummaryService.update(panoramicDailyInventorySummary);
		return ResultCode.getSuccessReturn(panoramicDailyInventorySummary);
	}

	@GetMapping("/{id}")
	public ResultCode<PanoramicDailyInventorySummary> detail(@PathVariable Integer id) {
		PanoramicDailyInventorySummary panoramicDailyInventorySummary = dailyInventorySummaryService
				.findById(id);
		return ResultCode.getSuccessReturn(panoramicDailyInventorySummary);
	}

	@GetMapping("/{date}/{page}/{size}")
	public ResultCode<PageInfo<PanoramicDailyInventorySummary>> list(@PathVariable String date,
			@PathVariable Integer page, @PathVariable Integer size) {
		PageHelper.startPage(page, size);
		List<PanoramicDailyInventorySummary> list = dailyInventorySummaryService.findAll();
		PageInfo<PanoramicDailyInventorySummary> pageInfo = new PageInfo<>(list);
		return ResultCode.getSuccessReturn(pageInfo);
	}
}
