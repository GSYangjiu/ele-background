package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.entity.Admin;
import com.yangmiemie.ele.entity.User;
import com.yangmiemie.ele.service.IAdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Admin> getAdminList() {
        return adminService.getAdminList();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getAdminCount(String date) {
        if (StringUtils.isBlank(date)) {
            return adminService.getAdminCount();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date newDate = sdf.parse(date);
                return adminService.getAdminCount(newDate);
            } catch (ParseException e) {
                LOGGER.error("AdminController getAdminCount METHOD ERROR " + e);
                return new Message(MessageType.M10004);
            }
        }
    }
}
