package com.yangmiemie.ele.controller;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.entity.Address;
import com.yangmiemie.ele.entity.User;
import com.yangmiemie.ele.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUserInfo() {
        return userService.getUserList();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getUserCount(@RequestParam(value = "date", required = false) Date date) {
        if (date == null) {
            return userService.getUserCount();
        } else {
            return userService.getUserCount(date);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserDetail(@PathVariable Long id) {
        return userService.getUserDetail(id);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Address getAddressById(@PathVariable Long id) {
        return userService.getAddressById(id);
    }
}