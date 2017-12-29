package com.cloud.web.controller.user;

import com.cloud.api.vo.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monitor.dto.user.PanoramicUserInfo;
import com.monitor.model.user.PanoramicUser;
import com.panoramic.user.acl.PanoramicUserService;
import com.cloud.util.HttpResult;
import com.cloud.web.util.WebUtils;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by @author summer on 2017/11/07.
 */
@RestController
@RequestMapping("/user")
public class PanoramicUserController {
    @Autowired
    @Qualifier("userService")
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
    
    @ApiOperation(value = "登录接口", notes = "根据输入用户密码获取用户基本信息")
    @RequestMapping(value = "/login", method = RequestMethod.POST) 
    public ResultCode<PanoramicUserInfo> login(
    			@RequestParam(value = "username", required = true) String name,  
            @RequestParam(value = "password", required = true) String password) {
    		PanoramicUserInfo panoramicUserMobile = panoramicUserService.getUserInfo(name,password);
    		return ResultCode.getSuccessReturn(panoramicUserMobile);
    }

    @ApiOperation(value = "登录接口", notes = "根据用户名密码登录到系统")
    @RequestMapping(value = "/weblogin", method = RequestMethod.POST)
    public ResultCode<PanoramicUserInfo> weblogin(
    			@RequestParam(value = "username", required = true) String name,  
            @RequestParam(value = "password", required = true) String password,
            HttpServletResponse response, HttpServletRequest request) {
    		PanoramicUserInfo panoramicUserWeb = panoramicUserService.loginWeb(name,password);
    		if (panoramicUserWeb != null) {
    			WebUtils.setLoginMemberKey(request,response);
    		}
    		return ResultCode.getSuccessReturn(panoramicUserWeb);
    }
    
    @ApiOperation(value = "登出接口", notes = "根据输入用户密码获取用户基本信息")
    @RequestMapping(value = "/weblogout", method = {RequestMethod.POST, RequestMethod.GET}) 
    public ResultCode<PanoramicUserInfo> weblogout(
    			@RequestParam(value = "username", required = true) String name,
    			HttpServletResponse response, HttpServletRequest request) {
    		WebUtils.removeLoginMemberKey(request, response);
    		return ResultCode.getSuccess("登出成功");
    }    
}
