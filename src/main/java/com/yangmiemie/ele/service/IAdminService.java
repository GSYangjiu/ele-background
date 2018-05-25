package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.service.ICrudService;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.dao.IAdminDAO;
import com.yangmiemie.ele.entity.Admin;

import java.util.Date;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 15:39
 * Description:
 */
public interface IAdminService extends ICrudService<IAdminDAO, Admin> {
    Message login(Admin admin);
}
