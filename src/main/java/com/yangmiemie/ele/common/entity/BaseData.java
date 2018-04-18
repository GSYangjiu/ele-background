package com.yangmiemie.ele.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 14:10
 * Description:
 */
public class BaseData implements Serializable {

    private static final long serialVersionUID = -6927950010529403683L;
    protected Long id;
    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;

    public BaseData() {
    }

    public BaseData(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
