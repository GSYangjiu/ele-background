package com.yangmiemie.ele.common.dao.impl;

import com.yangmiemie.ele.common.dao.IMGCurdDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 14:41
 * Description:
 */
public class MGCurdDAOImpl<T> implements IMGCurdDAO<T> {
    private final static Logger LOGGER = LoggerFactory.getLogger(MGCurdDAOImpl.class);

    @Autowired
    protected MongoTemplate mongoTemplate;

    Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public T find(Long id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), entityClass);
    }

    @Override
    public T findSelective(T entity) {
        Criteria criteria = new Criteria();
        criteria = getCriteria(entity, criteria);
        return mongoTemplate.findOne(new Query(criteria), entityClass);
    }

    /**
     * 分页查找
     * user代表过滤条件
     * pageable代表分页bean
     */
    @Override
    public List<T> findList(T entity, Pageable pageable) {
        Criteria criteria = new Criteria();
        criteria = getCriteria(entity, criteria);
        return mongoTemplate.find(new Query(criteria).with(pageable), entityClass);
    }

    private Criteria getCriteria(T entity, Criteria criteria) {
        if (entity != null) {
            Field[] fields = entityClass.getDeclaredFields();
            for (Field f : fields) {
                // 修改访问控制权限
                f.setAccessible(true);
                try {
                    if (f.get(entity) != null) {
                        criteria = criteria.and(f.getName()).is(f.get(entity));
                    }
                } catch (IllegalAccessException e) {
                    LOGGER.error("Exception:", e);
                }
            }
        }
        return criteria;
    }

    @Override
    public List<T> findList(Pageable pageable) {
        return mongoTemplate.find(new Query().with(pageable), entityClass);
    }

    @Override
    public Long getCount(T entity) {
        Query query = new Query();
        return mongoTemplate.count(query, entityClass);
    }

    @Override
    public int insert(T entity) {
        try {
            mongoTemplate.insert(entity);
            return 1;
        } catch (Exception e) {
            LOGGER.error("添加失败:", e);
            return -1;
        }
    }


    @Override
    public int update(T entity) {
        Criteria criteria = new Criteria();
        Update update = new Update();
        if (entity != null) {
            try {
                //获取id
                Field field = entityClass.getDeclaredField("id");
                field.setAccessible(true);
                criteria = Criteria.where("id").is(field.get(entity));

                //设置属性
                Field[] fields = entityClass.getDeclaredFields();
                for (Field f : fields) {
                    // 修改访问控制权限
                    f.setAccessible(true);
                    update = update.set(f.getName(), f.get(entity));
                }
            } catch (NoSuchFieldException e) {
                LOGGER.error("Entity 不具备 [id] 属性，", e);
            } catch (IllegalAccessException e) {
                LOGGER.error("Exception:", e);
            }
        }
        Query query = new Query(criteria);
        return (int) mongoTemplate.updateMulti(query, update, entityClass).getModifiedCount();
    }

    @Override
    public int updateSelective(T entity) {
        Criteria criteria = new Criteria();
        Update update = new Update();
        if (entity != null) {
            try {
                //获取id
                Field field = entityClass.getDeclaredField("id");
                field.setAccessible(true);
                criteria = Criteria.where("id").is(field.get(entity));

                //设置属性
                Field[] fields = entityClass.getDeclaredFields();
                for (Field f : fields) {
                    // 修改访问控制权限
                    f.setAccessible(true);
                    if (f.get(entity) != null) {
                        update = update.set(f.getName(), f.get(entity));
                    }
                }
            } catch (NoSuchFieldException e) {
                LOGGER.error("Entity 不具备 [id] 属性，", e);
            } catch (IllegalAccessException e) {
                LOGGER.error("Exception:", e);
            }
        }
        Query query = new Query(criteria);
        return (int) mongoTemplate.updateMulti(query, update, entityClass).getModifiedCount();
    }

    @Override
    public int delete(Long id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        return (int) mongoTemplate.remove(query, entityClass).getDeletedCount();
    }
}
