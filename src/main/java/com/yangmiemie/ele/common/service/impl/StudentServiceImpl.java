package com.yangmiemie.ele.common.service.impl;

import com.yangmiemie.ele.common.dao.UserDao;
import com.yangmiemie.ele.common.service.UserService;
import com.yangmiemie.ele.common.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 10:15
 * Description:
 */

@Service("userTestService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userTestDao;

    @Override
    public List<User> findAll() {
        return userTestDao.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userTestDao.getUser(id);
    }

    @Override
    public void update(User user) {
        userTestDao.update(user);
    }

    @Override
    public void insert(User user) {
        userTestDao.insert(user);
    }

    @Override
    public void insertAll(List<User> users) {
        userTestDao.insertAll(users);
    }

    @Override
    public void remove(Integer id) {
        userTestDao.remove(id);
    }

    @Override
    public List<User> findByPage(User user, Pageable pageable) {
        return userTestDao.findByPage(user, pageable);
    }
}
