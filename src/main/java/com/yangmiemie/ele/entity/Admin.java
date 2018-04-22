package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 15:42
 * Description:
 */
public class Admin extends BaseDataEntity<Admin> {

    private static final long serialVersionUID = -1850967873763024455L;
    private String username;
    private String password;
    private String city;
    private Integer authority;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",username:" + username + ",password:" + password + ",city:" + city + ",authority:" + authority + "}";
    }
}
