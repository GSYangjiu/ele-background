package com.yangmiemie.ele.common.service.impl;

import com.sun.istack.internal.logging.Logger;
import com.yangmiemie.ele.common.dao.IMGCurdDAO;
import com.yangmiemie.ele.common.persistence.BaseEntity;
import com.yangmiemie.ele.common.service.ICrudService;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-24 11:44
 * Description:
 */
public class CrudService<D extends IMGCurdDAO<T>, T extends BaseEntity<T>> implements ICrudService<D, T> {

    @Autowired
    protected D dao;

    protected static final Logger logger = Logger.getLogger(CrudService.class);

    @Override
    public List<T> findByPage(Pageable page) {
        return dao.findList(page);
    }

    @Override
    public Message getCount(T entity) {
        Message msg = new Message();
        msg.getMap().put("count", dao.getCount(entity));
        return msg;
    }

    @Override
    public T getDetail(Long id) {
        return dao.find(id);
    }

    @Override
    public Message add(T entity) {
        return dao.insert(entity) == -1 ? new Message(MessageType.M99999) : new Message();
    }

    @Override
    public Message delete(Long id) {
        return dao.delete(id) == 1 ? new Message() : new Message(MessageType.M99999);
    }

    @Override
    public Message update(T entity) {
        return dao.update(entity) == 1 ? new Message() : new Message(MessageType.M99999);
    }
}
