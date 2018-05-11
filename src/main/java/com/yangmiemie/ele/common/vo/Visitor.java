package com.yangmiemie.ele.common.vo;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-11 16:43
 * Description:
 */
public class Visitor {
    private Integer count;
    private String city;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "count=" + count +
                ", city='" + city + '\'' +
                '}';
    }
}
