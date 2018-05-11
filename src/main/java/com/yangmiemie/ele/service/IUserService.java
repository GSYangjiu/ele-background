package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.entity.Address;
import com.yangmiemie.ele.entity.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:35
 * Description:
 */
public interface IUserService {


    /**
     * 获取用户列表
     *
     * @return
     */
    public List<User> getUserList();

    /**
     * 获取用户总量
     *
     * @return
     */
    public Message getUserCount();

    /**
     * 获取当天注册用户量
     *
     * @param date
     * @return
     */
    public Message getUserCount(Date date);


    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    public User getUserDetail(Long id);

    /**
     * 获取用户收货地址
     *
     * @param id AddressNum
     * @return
     */
    public Address getAddressById(Long id);

    /**
     * 获取用户分布信息
     *
     * @return
     */
    public Message getUserCityCount();
}
