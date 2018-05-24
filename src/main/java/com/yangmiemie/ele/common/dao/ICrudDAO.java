package com.yangmiemie.ele.common.dao;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 11:16
 * Description:
 */
public interface ICrudDAO<T> {
    public T find(Long id);

    public T findSelective(T entity);

    public List<T> findList(T entity);

    public int getCount(T entity);

    public int insert(T entity);

    public int insertSelective(T entity);

    public int update(T entity);

    public int updateSelective(T entity);

    public int delete(Long id);

    public int deleteSelective(T entity);
}
