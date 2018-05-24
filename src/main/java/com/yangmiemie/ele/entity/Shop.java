package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;
import com.yangmiemie.ele.common.vo.Activity;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 16:21
 * Description:
 */

public class Shop extends BaseDataEntity<Shop> {

    private static final long serialVersionUID = -3809006974131572855L;
    private String name;
    private String address;
    private String category;
    private String phone;

    //商铺特点
    private Boolean bao;
    private Boolean news;
    private Boolean piao;
    private Boolean zhun;
    private Boolean deliveryMode;
    private Boolean premium;
    private String description;
    private String promotionInfo;

    //经纬度
    private String latitude;
    private String longitude;
    //营业时间
    private String startTime;
    private String endTime;

    //配送费&起送价
    private Double floatDeliveryFee;
    private Double floatMinimumOrderAmount;

    //图片路径
    private String imagePath;
    private String businessLicenseImage;
    private String cateringServiceLicenseImage;

    //活动列表
    private List<Activity> activities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getBao() {
        return bao;
    }

    public void setBao(Boolean bao) {
        this.bao = bao;
    }

    public Boolean getNews() {
        return news;
    }

    public void setNews(Boolean news) {
        this.news = news;
    }

    public Boolean getPiao() {
        return piao;
    }

    public void setPiao(Boolean piao) {
        this.piao = piao;
    }

    public Boolean getZhun() {
        return zhun;
    }

    public void setZhun(Boolean zhun) {
        this.zhun = zhun;
    }

    public Boolean getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Boolean deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getFloatDeliveryFee() {
        return floatDeliveryFee;
    }

    public void setFloatDeliveryFee(Double floatDeliveryFee) {
        this.floatDeliveryFee = floatDeliveryFee;
    }

    public Double getFloatMinimumOrderAmount() {
        return floatMinimumOrderAmount;
    }

    public void setFloatMinimumOrderAmount(Double floatMinimumOrderAmount) {
        this.floatMinimumOrderAmount = floatMinimumOrderAmount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBusinessLicenseImage() {
        return businessLicenseImage;
    }

    public void setBusinessLicenseImage(String businessLicenseImage) {
        this.businessLicenseImage = businessLicenseImage;
    }

    public String getCateringServiceLicenseImage() {
        return cateringServiceLicenseImage;
    }

    public void setCateringServiceLicenseImage(String cateringServiceLicenseImage) {
        this.cateringServiceLicenseImage = cateringServiceLicenseImage;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", phone='" + phone + '\'' +
                ", bao=" + bao +
                ", news=" + news +
                ", piao=" + piao +
                ", zhun=" + zhun +
                ", deliveryMode=" + deliveryMode +
                ", isPremium=" + premium +
                ", description='" + description + '\'' +
                ", promotionInfo='" + promotionInfo + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", floatDeliveryFee=" + floatDeliveryFee +
                ", floatMinimumOrderAmount=" + floatMinimumOrderAmount +
                ", imagePath='" + imagePath + '\'' +
                ", businessLicenseImage='" + businessLicenseImage + '\'' +
                ", cateringServiceLicenseImage='" + cateringServiceLicenseImage + '\'' +
                ", activities=" + activities +
                ", _id='" + _id + '\'' +
                ", id=" + id +
                '}';
    }
}
