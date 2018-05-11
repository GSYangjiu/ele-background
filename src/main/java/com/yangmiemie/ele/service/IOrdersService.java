package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.entity.Orders;

import java.util.Date;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-05 01:27
 * Description:
 */
public interface IOrdersService {

    /**
     * 获取订单总数
     *
     * @param shopId 为null获取总订单数
     * @return
     */
    public Message getOrdersCount(Long shopId);


    /**
     * 获取当天订单总量1
     *
     * @param date
     * @return
     */
    public Message getOrdersCount(Date date);


    /**
     * 获取订单列表
     *
     * @param page
     * @param shopId 为null获取总列表
     * @return
     */
    public List<Orders> getOrdersList(Page<Orders> page, Long shopId);
}
