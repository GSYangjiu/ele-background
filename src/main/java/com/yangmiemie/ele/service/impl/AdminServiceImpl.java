package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.MD5Util;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.dao.IAdminDAO;
import com.yangmiemie.ele.entity.Admin;
import com.yangmiemie.ele.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 15:49
 * Description:
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminDAO adminDAO;

    private static final Admin ADMIN = new Admin();

    @Override
    public Message login(Admin admin) {
        Message msg;
        Admin adminTemp = new Admin();
        adminTemp.setUsername(admin.getUsername());
        Admin adminRst = adminDAO.findSelective(adminTemp);
        String str = MD5Util.MD5(admin.getPassword());
        if (adminRst == null) {
            //不存在该用户，以该用户名注册
            admin.setPassword(str);
            admin.setAuthority(0);
            admin.preInsert();
            adminDAO.insertSelective(admin);
            msg = new Message(MessageType.M10003);
        } else {
            if (str.equals(adminRst.getPassword())) {
                msg = new Message(MessageType.M10001);
            } else {
                msg = new Message(MessageType.M10002);
            }
        }
        return msg;
    }

    @Override
    public List<Admin> getAdminList() {
        return adminDAO.findList(ADMIN);
    }

    @Override
    public Message getAdminCount() {
        Message msg = new Message();
        msg.getMap().put("count", adminDAO.getCount(ADMIN));
        return msg;
    }

    @Override
    public Message getAdminCount(Date date) {
        Message msg = new Message();
        Admin admin = new Admin();
        admin.setCreateTime(date);
        msg.getMap().put("count", adminDAO.getCount(admin));
        return msg;
    }
}
