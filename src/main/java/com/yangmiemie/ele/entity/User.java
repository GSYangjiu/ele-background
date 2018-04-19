package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.entity.BaseData;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:17
 * Description:
 */

public class User extends BaseData {
    private static final long serialVersionUID = 7641588799628633361L;
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",name:" + name + ",city:" + city + "}";
    }
}
