package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

import java.util.Objects;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-02 11:14
 * Description:
 */
public class GoodsSpec extends BaseDataEntity<GoodsSpec> {
    private static final long serialVersionUID = -7102042299956387906L;

    private Long goodsId;
    private String name;
    private Double price;
    private String packingFee;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(String packingFee) {
        this.packingFee = packingFee;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",goodsId:" + goodsId + ",name:" + name + ",price:" + price + ",packingFee:" + packingFee + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoodsSpec)) return false;
        if (!super.equals(o)) return false;
        GoodsSpec goodsSpec = (GoodsSpec) o;
        return Objects.equals(getGoodsId(), goodsSpec.getGoodsId()) &&
                Objects.equals(getName(), goodsSpec.getName()) &&
                Objects.equals(getPrice(), goodsSpec.getPrice()) &&
                Objects.equals(getPackingFee(), goodsSpec.getPackingFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoodsId(), getName(), getPrice(), getPackingFee());
    }
}