package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-05 13:44
 * Description:
 */
public class Address extends BaseDataEntity<Address> {
    private static final long serialVersionUID = 1492633223606811650L;
    private Integer userId;
    private String address;
    private Integer type;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",userId:" + userId + ",address:" + address + ",type:" + type + "}";
    }
}
