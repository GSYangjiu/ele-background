package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.entity.User;
import com.yangmiemie.ele.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:33
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public List<User> getUserInfo() {
        return userService.getUserList();
    }
}