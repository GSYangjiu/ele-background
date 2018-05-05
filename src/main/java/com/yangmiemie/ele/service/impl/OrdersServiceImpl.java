package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.dao.IOrdersDAO;
import com.yangmiemie.ele.entity.Orders;
import com.yangmiemie.ele.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-05 01:31
 * Description:
 */
@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDAO ordersDAO;

    @Override
    public Message getOrdersCount(Long shopId) {
        Message msg = new Message();
        Orders orders = new Orders();
        orders.setShopId(shopId);
        msg.getMap().put("count", ordersDAO.getCount(orders));
        return msg;
    }

    @Override
    public List<Orders> getOrdersList(Page<Orders> page, Long shopId) {
        Orders orders = new Orders();
        orders.setShopId(shopId);
        return ordersDAO.findList(orders);
    }
}
