package com.yangmiemie.ele.dao;

import com.yangmiemie.ele.common.dao.CurdDAO;
import com.yangmiemie.ele.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:14
 * Description:
 */
@Mapper
public interface IUserDAO extends CurdDAO<User> {

    List<User> findList(User entity);
}
