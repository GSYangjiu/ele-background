package com.yangmiemie.ele.common.entity;

import java.io.Serializable;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 14:10
 * Description:
 */
public class BaseData implements Serializable {

    private static final long serialVersionUID = -6927950010529403683L;
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
