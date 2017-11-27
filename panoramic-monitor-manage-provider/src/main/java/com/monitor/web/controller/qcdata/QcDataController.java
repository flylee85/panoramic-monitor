package com.monitor.web.controller.qcdata;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.materialthresholdconfiguration.PanoramicMaterialThresholdConfigurationService;
import com.monitor.api.qcdata.QcDataService;
import com.monitor.model.qcdata.QcData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author summer
 * 2017/11/27
 */
@Api
@RestController
@RequestMapping("/qc/data")
public class QcDataController {
    @Autowired
    @Qualifier("qcDataService")
    private QcDataService qcDataService;

    @PostMapping("/{id}")
    public ResultCode<QcData> add(QcData qcData) {
        qcDataService.save(qcData);
        return ResultCode.getSuccessReturn(qcData);
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<QcData> update(QcData qcData) {
        qcDataService.update(qcData);
        return ResultCode.getSuccessReturn(qcData);
    }

    @GetMapping("/{id}")
    public ResultCode<QcData> detail(@PathVariable Integer id) {
        QcData qcData = qcDataService.findById(id);
        return ResultCode.getSuccessReturn(qcData);
    }
    @GetMapping("/{date}")
    public ResultCode<Double> passRate(@PathVariable String date) {
        Double passRate = qcDataService.passRate(date);
        return ResultCode.getSuccessReturn(passRate);
    }

    @ApiOperation(value = "分页查询质检详情查询接口", notes = "根据时间分页查询质检详情数据列表")
    @GetMapping("/{date}/{page}/{size}")
    public ResultCode<PageInfo<List<QcData>>> list(@PathVariable String date, @PathVariable Integer page, @PathVariable Integer size) {
        PageHelper.startPage(page, size);
        List<QcData> list = qcDataService.listByDate(date);
        PageInfo<List<QcData>> pageInfo = new PageInfo(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}
