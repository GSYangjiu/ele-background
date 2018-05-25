package com.yangmiemie.ele.dao.impl;

import com.yangmiemie.ele.common.dao.impl.MGCurdDAOImpl;
import com.yangmiemie.ele.dao.IAdminDAO;
import com.yangmiemie.ele.entity.Admin;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-25 09:05
 * Description:
 */
@Repository("adminDao")
public class AdminDAOImpl extends MGCurdDAOImpl<Admin> implements IAdminDAO {
    @Override
    public Long getCount(Admin admin) {
        Query query = new Query();
        if (admin != null) {
            if (admin.getCreateTime() != null) {
                //注册早于当前
                query = new Query(Criteria.where("create_time").gte(admin.getCreateTime()));
            }
        }
        return mongoTemplate.count(query, Admin.class);
    }
}
