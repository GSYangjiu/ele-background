package com.yangmiemie.ele.dao;

import com.yangmiemie.ele.common.dao.IMGCurdDAO;
import com.yangmiemie.ele.common.vo.Visitor;
import com.yangmiemie.ele.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:14
 * Description:
 */
public interface IUserDAO extends IMGCurdDAO<User> {
    List<Visitor> getUserCityCount();
}
