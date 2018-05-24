package com.yangmiemie.ele.common.dao.impl;

import com.yangmiemie.ele.common.dao.IStudentDAO;
import com.yangmiemie.ele.common.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 11:28
 * Description:
 */
@Repository("userTestDao")
public class UserDaoImpl implements IStudentDAO {
    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查找全部
     */
    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

    /**
     * 根据id得到对象
     */
    @Override
    public Student getUser(Integer id) {


        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Student.class);
    }

    /**
     * 插入一个用户
     */
    @Override
    public void insert(Student user) {
        mongoTemplate.insert(user);
    }

    /**
     * 根据id删除一个用户
     */
    @Override
    public void remove(Integer id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, Student.class);
    }

    /**
     * 分页查找
     * <p>
     * user代表过滤条件
     * <p>
     * pageable代表分页bean
     */
    @Override
    public List<Student> findByPage(Student user, Pageable pageable) {
        Query query = new Query();
        if (user != null && user.getName() != null) {
            //模糊查询
            query = new Query(Criteria.where("name").regex("^" + user.getName()));
        }
        List<Student> list = mongoTemplate.find(query.with(pageable), Student.class);
        return list;
    }

    /**
     * 根据id更新
     */
    @Override
    public void update(Student user) {
        Criteria criteria = Criteria.where("id").is(user.getId());
        Query query = new Query(criteria);
        Update update = Update.update("name", user.getName()).set("age", user.getAge());
        mongoTemplate.updateMulti(query, update, Student.class);
    }

    /**
     * 插入一个集合
     */
    @Override
    public void insertAll(List<Student> users) {
        mongoTemplate.insertAll(users);
    }
}
