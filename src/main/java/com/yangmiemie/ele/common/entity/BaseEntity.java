package com.yangmiemie.ele.common.entity;

import com.google.common.collect.Maps;
import com.yangmiemie.ele.common.utils.Pages;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:18
 * Description:
 */
public abstract class BaseEntity<T> implements Serializable {

    protected Long id;

    /**
     * 当前实体分页对象
     */
    protected Pages<T> pages;

    /**
     * 排序方式
     */
    protected String order;

    /**
     * 自定义SQL（SQL标识，SQL内容）
     */
    protected Map<String, String> sqlMap;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Pages<T> getPages() {
        if (pages == null) {
            pages = new Pages<T>();
        }
        return pages;
    }

    public Pages<T> setPages(Pages<T> pages) {
        this.pages = pages;
        return pages;
    }

    public Map<String, String> getSqlMap() {
        if (sqlMap == null) {
            sqlMap = Maps.newHashMap();
        }
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    /**
     * 插入之前执行方法，子类实现
     */
    public void preInsert() {

    }

    /**
     * 更新之前执行方法，子类实现
     */
    public void preUpdate() {

    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        BaseEntity<?> that = (BaseEntity<?>) obj;
        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
