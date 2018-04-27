package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-27 11:07
 * Description:
 */
public class GoodsType extends BaseDataEntity<GoodsType> {
    private static final long serialVersionUID = 7885687773292917769L;
    private String type;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + ",type:" + type + ",description:" + description + "}";
    }
}
