package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.dao.IUserDAO;
import com.yangmiemie.ele.entity.User;
import com.yangmiemie.ele.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:37
 * Description:
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO userDao;

    static final private User user = new User();

    @Override
    public List<User> getUserList() {
        return userDao.findList(user);
    }

    @Override
    public Message getUserCount() {
        Message msg = new Message();
        msg.getMap().put("count", userDao.getCount(user));
        return msg;
    }
}
