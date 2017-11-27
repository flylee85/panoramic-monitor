package com.cloud.web.controller.role;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panoramic.user.acl.PanoramicRoleService;
import com.panoramic.user.entity.PanoramicRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunmer
 * on 2017/11/06.
 */
@RestController
@RequestMapping("/panoramic/role")
public class PanoramicRoleController {
    @Autowired
    private PanoramicRoleService panoramicRoleService;

    @PostMapping
    public ResultCode<PanoramicRole> add(PanoramicRole panoramicRole) {
        panoramicRoleService.save(panoramicRole);
        return ResultCode.getSuccessReturn(panoramicRole);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicRole> delete(@PathVariable Integer id) {
        panoramicRoleService.deleteById(id);
        return ResultCode.getSuccessMap();
    }

    @PutMapping
    public ResultCode<PanoramicRole> update(PanoramicRole panoramicRole) {
        panoramicRoleService.update(panoramicRole);
        return ResultCode.getSuccessReturn(panoramicRole);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicRole> detail(@PathVariable Integer id) {
        PanoramicRole panoramicRole = panoramicRoleService.findById(id);
        return ResultCode.getSuccessReturn(panoramicRole);
    }

    @GetMapping
    public ResultCode<PageInfo> list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicRole> list = panoramicRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}
