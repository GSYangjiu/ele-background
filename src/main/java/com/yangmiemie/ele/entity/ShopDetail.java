package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

import java.util.Date;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-11 10:55
 * Description:
 */
public class ShopDetail extends BaseDataEntity<ShopDetail> {
    private static final long serialVersionUID = -7421515909829970140L;
    private Integer shopId;
    private String slogan;
    private Date beginTime;
    private Date endTime;
    private Boolean feateres1;
    private Boolean feateres2;
    private Boolean feateres3;
    private Boolean feateres4;
    private Boolean feateres5;
    private Boolean feateres6;
    private Integer deliveryFee;
    private Integer startPrice;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getFeateres1() {
        return feateres1;
    }

    public void setFeateres1(Boolean feateres1) {
        this.feateres1 = feateres1;
    }

    public Boolean getFeateres2() {
        return feateres2;
    }

    public void setFeateres2(Boolean feateres2) {
        this.feateres2 = feateres2;
    }

    public Boolean getFeateres3() {
        return feateres3;
    }

    public void setFeateres3(Boolean feateres3) {
        this.feateres3 = feateres3;
    }

    public Boolean getFeateres4() {
        return feateres4;
    }

    public void setFeateres4(Boolean feateres4) {
        this.feateres4 = feateres4;
    }

    public Boolean getFeateres5() {
        return feateres5;
    }

    public void setFeateres5(Boolean feateres5) {
        this.feateres5 = feateres5;
    }

    public Boolean getFeateres6() {
        return feateres6;
    }

    public void setFeateres6(Boolean feateres6) {
        this.feateres6 = feateres6;
    }

    public Integer getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Integer deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",shopId:" + shopId + ",slogan:" + slogan + ",beginTime:" + beginTime + ",endTime:" + endTime + ",feateres1:" + feateres1 + ",feateres2:" + feateres2 + ",feateres3:" + feateres3 + ",feateres4:" + feateres4 + ",feateres5:" + feateres5 + ",feateres6:" + feateres6 + ",deliveryFee:" + deliveryFee + ",startPrice:" + startPrice + "}";
    }
}
