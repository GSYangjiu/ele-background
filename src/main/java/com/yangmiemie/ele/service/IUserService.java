package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.service.ICrudService;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.dao.IUserDAO;
import com.yangmiemie.ele.entity.Address;
import com.yangmiemie.ele.entity.User;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:35
 * Description:
 */
public interface IUserService extends ICrudService<IUserDAO, User> {
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
