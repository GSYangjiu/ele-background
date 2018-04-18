package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.entity.Admin;
import com.yangmiemie.ele.service.IAdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiImplicitParam(name = "admin", value = "用户名&密码", required = true, dataType = "Admin")
    public Message login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }
}
