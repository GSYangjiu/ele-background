package com.yangmiemie.ele.dao.impl;

import com.yangmiemie.ele.common.dao.impl.MGCurdDAOImpl;
import com.yangmiemie.ele.common.vo.Visitor;
import com.yangmiemie.ele.dao.IUserDAO;
import com.yangmiemie.ele.entity.User;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 15:09
 * Description:
 */
@Repository("userDao")
public class UserDAOImpl extends MGCurdDAOImpl<User> implements IUserDAO {
    @Override
    public List<Visitor> getUserCityCount() {
        AggregationResults<Visitor> agg = mongoTemplate.aggregate(
                Aggregation.newAggregation(
                        Aggregation.group("city").count().as("count")
                ), User.class, Visitor.class
        );
        return agg.getMappedResults();
    }

    @Override
    public Long getCount(User user) {
        Query query = new Query();
        if (user != null) {
            if (user.getCreateTime() != null) {
                //注册早于当前
                query = new Query(Criteria.where("create_time").gte(user.getCreateTime()));
            }
        }
        return mongoTemplate.count(query, User.class);
    }
}
