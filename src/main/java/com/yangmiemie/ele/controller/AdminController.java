package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.entity.Admin;
import com.yangmiemie.ele.service.IAdminService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/login")
    public Message login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @GetMapping("/list")
    public List<Admin> getAdminList(Pageable page) {
        return adminService.findByPage(page);
    }

    @GetMapping("/count")
    public Message getAdminCount(String date) {
        Admin entity = new Admin();
        if (StringUtils.isNotBlank(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date newDate = sdf.parse(date);
                entity.setCreateTime(newDate);
            } catch (ParseException e) {
                LOGGER.error("AdminController getAdminCount METHOD ERROR " + e);
                return new Message(MessageType.M10004);
            }
        }
        return adminService.getCount(entity);
    }
}
