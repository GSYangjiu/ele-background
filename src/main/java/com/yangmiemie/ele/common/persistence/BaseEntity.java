package com.yangmiemie.ele.common.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.common.utils.autoKey.AutoIncKey;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public abstract class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = 9063351392591468509L;
    /**
     * 实体编号（唯一标识）
     */
    @Id
    protected String _id;
    @AutoIncKey
    protected Long id;
    @JsonIgnore
    private String createBy;
    @JsonIgnore
    private String updateBy;
    @JsonIgnore
    @Field("create_time")
    private Date createTime;
    @JsonIgnore
    @Field("update_time")
    private Date updateTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 当前实体分页对象
     */
    protected Pages<T> pages;
    /**
     * 自定义SQL（SQL标识，SQL内容）
     */

    @JsonIgnore
    protected Map<String, String> sqlMap;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this();
        this.id = id;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pages<T> getPages() {
        if (pages == null) {
            pages = new Pages<T>();
        }
        return pages;
    }

    @JsonIgnore
    public Pages<T> setPages(Page<T> page) {
        this.id = page.getId();
        this.pages = new Pages<T>(page);
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
    public abstract void preInsert();

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();

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
