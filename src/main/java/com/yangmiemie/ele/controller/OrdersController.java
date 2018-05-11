package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.entity.Orders;
import com.yangmiemie.ele.service.IOrdersService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Orders> getShopList(Page<Orders> page, @RequestParam(value = "shopId", required = false) Long shopId) {
        return ordersService.getOrdersList(page, shopId);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getOrderCount(@RequestParam(value = "shopId", required = false) Long shopId, @RequestParam(value = "date", required = false) String date) {
        if (StringUtils.isBlank(date)) {
            return ordersService.getOrdersCount(shopId);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date newDate = sdf.parse(date);
                return ordersService.getOrdersCount(newDate);
            } catch (ParseException e) {
                LOGGER.error("OrdersController getOrderCount METHOD ERROR " + e);
                return new Message(MessageType.M10004);
            }
        }
    }
}
