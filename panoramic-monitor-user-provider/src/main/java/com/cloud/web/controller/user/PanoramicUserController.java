package com.cloud.web.controller.user;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panoramic.user.acl.PanoramicUserService;
import com.panoramic.user.entity.PanoramicUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by @author sunmer on 2017/11/07.
 */
@RestController
@RequestMapping("/noramic/user")
public class PanoramicUserController {
    @Autowired
    private PanoramicUserService panoramicUserService;

    @PostMapping
    public ResultCode<PanoramicUser> add(PanoramicUser panoramicUser) {
        panoramicUserService.save(panoramicUser);
        return ResultCode.getSuccessReturn(panoramicUser);
    }

    @DeleteMapping("/{id}")
    public ResultCode<PanoramicUser> delete(@PathVariable Integer id) {
        panoramicUserService.deleteById(id);
        return ResultCode.getSuccessMap();
    }

    @PutMapping
    public ResultCode<PanoramicUser> update(PanoramicUser panoramicUser) {
        panoramicUserService.update(panoramicUser);
        return ResultCode.getSuccessReturn(panoramicUser);
    }

    @GetMapping("/{id}")
    public ResultCode<PanoramicUser> detail(@PathVariable Integer id) {
        PanoramicUser panoramicUser = panoramicUserService.findById(id);
        return ResultCode.getSuccessReturn(panoramicUser);
    }

    @GetMapping
    public ResultCode<PageInfo> list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<PanoramicUser> list = panoramicUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultCode.getSuccessReturn(pageInfo);
    }
}
