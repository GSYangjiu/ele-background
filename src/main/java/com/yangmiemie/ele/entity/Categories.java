package com.yangmiemie.ele.entity;

import com.yangmiemie.ele.common.persistence.BaseDataEntity;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-24 16:24
 * Description:
 */
public class Categories extends BaseDataEntity<Categories> {
    private Integer num;
    private String name;
    private Integer parentNum;
    public Integer getNum(){
        return num;
    }

    public void setNum(Integer num){
        this.num=num;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Integer getParentNum(){
        return parentNum;
    }

    public void setParentNum(Integer parentNum){
        this.parentNum=parentNum;
    }

    @Override
    public String toString() { return "{"+super.toString()+",num:"+num+",name:"+name+",parentNum:"+parentNum+"}";
    }
}