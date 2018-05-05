package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

import java.util.Date;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-05 01:20
 * Description:
 */
public class Orders extends BaseDataEntity<Orders> {
    private static final long serialVersionUID = 285012009894739752L;
    private Integer userId;
    private Long shopId;
    private Double price;
    private String status;
    private Integer addressNum;
    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(Integer addressNum) {
        this.addressNum = addressNum;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",userId:" + userId + ",shopId:" + shopId + ",price:" + price + ",status:" + status + ",addressNum:" + addressNum + "}";
    }
}