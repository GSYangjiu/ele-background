package com.yangmiemie.ele.common.utils;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 16:52
 * Description:
 */
public class Page<T> {
    private Long id;
    private int offset;
    private int limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
