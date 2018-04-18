package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.entity.BaseData;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 15:42
 * Description:
 */
public class Admin extends BaseData {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",username:" + username + ",password:" + password + "}";
    }
}
