package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.entity.Address;
import com.yangmiemie.ele.entity.User;
import com.yangmiemie.ele.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/list")
    public List<User> getUserInfo(Pageable page) {
        return userService.findByPage(page);
    }

    @GetMapping("/count")
    public Message getUserCount(String date) {
        User user = new User();
        if (StringUtils.isNotBlank(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date newDate = sdf.parse(date);
                user.setCreateTime(newDate);
            } catch (ParseException e) {
                LOGGER.error("UserController getUserCount METHOD ERROR " + e);
                return new Message(MessageType.M10004);
            }
        }
        return userService.getCount(user);
    }

    @GetMapping("/{id}")
    public User getUserDetail(@PathVariable Long id) {
        return userService.getDetail(id);
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return userService.getAddressById(id);
    }

    @GetMapping("/city/count")
    public Message getUserCityCount() {
        return userService.getUserCityCount();
    }
}