package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.dao.IAddressDAO;
import com.yangmiemie.ele.dao.IUserDAO;
import com.yangmiemie.ele.entity.Address;
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

    @Autowired
    private IAddressDAO addressDAO;

    static final private User USER = new User();

    @Override
    public List<User> getUserList() {
        return userDao.findList(USER);
    }

    @Override
    public Message getUserCount() {
        Message msg = new Message();
        msg.getMap().put("count", userDao.getCount(USER));
        return msg;
    }

    @Override
    public User getUserDetail(Long id) {
        return userDao.find(id);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressDAO.find(id);
    }
}
