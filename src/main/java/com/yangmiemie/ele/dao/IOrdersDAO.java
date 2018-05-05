package com.yangmiemie.ele.dao;

import com.yangmiemie.ele.common.dao.CurdDAO;
import com.yangmiemie.ele.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-05 01:26
 * Description:
 */

@Mapper
public interface IOrdersDAO extends CurdDAO<Orders> {
}
