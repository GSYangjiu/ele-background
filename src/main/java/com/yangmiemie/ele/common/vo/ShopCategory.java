package com.yangmiemie.ele.common.vo;

import com.yangmiemie.ele.entity.Categories;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-26 10:01
 * Description:
 */
public class ShopCategory {
    private String id;
    private Categories sub_categories;
    private List<Categories> child;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Categories getCategories() {
        return sub_categories;
    }

    public void setCategories(Categories categories) {
        this.sub_categories = categories;
    }

    public List<Categories> getChild() {
        return child;
    }

    public void setChild(List<Categories> child) {
        this.child = child;
    }
}
