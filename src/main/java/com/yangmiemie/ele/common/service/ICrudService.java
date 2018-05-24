package com.yangmiemie.ele.common.service;

import com.yangmiemie.ele.common.dao.IMGCurdDAO;
import com.yangmiemie.ele.common.persistence.BaseEntity;
import com.yangmiemie.ele.common.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-24 11:05
 * Description:
 */
public interface ICrudService<D extends IMGCurdDAO<T>, T extends BaseEntity<T>> {

    Logger LOGGER = LoggerFactory.getLogger(ICrudService.class);

    List<T> findByPage(Pageable page);

    Message getCount(T entity);

    T getDetail(Long id);

    Message add(T entity);

    Message delete(Long id);

    Message update(T entity);
}
