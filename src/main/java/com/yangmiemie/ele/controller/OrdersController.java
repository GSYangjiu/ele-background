package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.entity.Orders;
import com.yangmiemie.ele.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-05 01:27
 * Description:
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Orders> getShopList(Page<Orders> page, @RequestParam(value = "shopId", required = false) Long shopId) {
        return ordersService.getOrdersList(page, shopId);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getAdminCount(@RequestParam(value = "shopId", required = false) Long shopId) {
        return ordersService.getOrdersCount(shopId);
    }
}
