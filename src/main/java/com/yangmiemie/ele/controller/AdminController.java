package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.entity.Admin;
import com.yangmiemie.ele.entity.User;
import com.yangmiemie.ele.service.IAdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 14:35
 * Description:
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "管理员登陆", notes = "登陆，未注册用户直接注册")
    @ApiImplicitParam(name = "admin", value = "用户名&密码", required = true, dataType = "Admin")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParam(name = "adminList", value = "index&limit", required = true, dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Admin> getAdminList() {
        return adminService.getAdminList();
    }

    @ApiOperation(value = "获取管理员总数")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getAdminCount() {
        return adminService.getAdminCount();
    }
}
