package com.yangmiemie.ele.common.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 14:38
 * Description:
 */
public interface IMGCurdDAO<T> {
    T find(Long id);

    T findSelective(T entity);

    List<T> findList(Pageable pageable);

    List<T> findList(T entity, Pageable pageable);

    Long getCount(T entity);

    int insert(T entity);

    int update(T entity);

    int updateSelective(T entity);

    int delete(Long id);
}
