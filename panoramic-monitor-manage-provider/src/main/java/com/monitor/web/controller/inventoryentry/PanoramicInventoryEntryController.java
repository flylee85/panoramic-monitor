package com.monitor.web.controller.inventoryentry;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.api.inventoryentry.PanoramicInventoryEntryService;
import com.monitor.model.inventoryentry.PanoramicInventoryEntry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author summer 2017/11/30
 */
@Api
@RestController
@RequestMapping("/panoramic/inventory/entry")
public class PanoramicInventoryEntryController {
    @Autowired
    @Qualifier("inventoryEntryService")
    private PanoramicInventoryEntryService inventoryEntryService;

    @ApiOperation(value = "人工录入保存数据接口", notes = "人工录入数据，按照排班分别保存对应数据")
    @PostMapping
    public ResultCode<Void> add( @RequestBody List<PanoramicInventoryEntry> inventoryEntryList) {
        if (null == inventoryEntryList || inventoryEntryList.size() == 0) {
            return ResultCode.getFailure("上传数据格式错误！");
        }
        inventoryEntryService.saveOrUpdate(inventoryEntryList);
        return ResultCode.SUCCESS;
    }

    @DeleteMapping("/{id}")
    public ResultCode<Void> delete(@PathVariable Integer id) {
        return ResultCode.SUCCESS;
    }

    @PutMapping
    public ResultCode<PanoramicInventoryEntry> update(PanoramicInventoryEntry panoramicInventoryEntry) {
        inventoryEntryService.update(panoramicInventoryEntry);
        return ResultCode.getSuccessReturn(panoramicInventoryEntry);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicInventoryEntry> detail(@PathVariable Integer id) {
        PanoramicInventoryEntry panoramicInventoryEntry = inventoryEntryService.findById(id);
        return ResultCode.getSuccessReturn(panoramicInventoryEntry);
    }

    @GetMapping("/{date}/{page}/{size}")
    public ResultCode<PageInfo> list(@PathVariable("date") String date, @PathVariable("page") Integer page,
                                     @PathVariable("size") Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicInventoryEntry> list = inventoryEntryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}
