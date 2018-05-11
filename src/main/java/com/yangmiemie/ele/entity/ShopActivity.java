package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

import java.util.Date;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-11 10:59
 * Description:
 */
public class ShopActivity extends BaseDataEntity<ShopActivity> {
    private static final long serialVersionUID = -520617091639868865L;
    private Integer shopId;
    private Integer activityNum;
    private String detail;
    private Integer status;
    private Date beginTime;
    private Date endTime;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Integer activityNum) {
        this.activityNum = activityNum;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "{" + super.toString() + ",shopId:" + shopId + ",activityNum:" + activityNum + ",detail:" + detail + ",status:" + status + ",beginTime:" + beginTime + ",endTime:" + endTime + "}";
    }
}