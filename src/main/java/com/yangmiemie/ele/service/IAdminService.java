package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.entity.Admin;

import java.util.Date;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 15:39
 * Description:
 */
public interface IAdminService {
    public Message login(Admin admin);


    /**
     * 获取管理员列表
     *
     * @return
     */
    public List<Admin> getAdminList();

    /**
     * 获取管理员总数
     *
     * @return
     */
    public Message getAdminCount();

    /**
     * 获取当天注册管理员数量
     *
     * @param date
     * @return
     */
    public Message getAdminCount(Date date);
}
