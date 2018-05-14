package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.entity.Goods;
import com.yangmiemie.ele.entity.GoodsType;
import com.yangmiemie.ele.service.IGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-27 14:09
 * Description:
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    private final static Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Goods> getShopList(Page<Goods> page) {
        return goodsService.getGoodsList(page);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getShopCount(@RequestParam(value = "shopId", required = false) Long shopId) {
        return goodsService.getGoodsCount(shopId);
    }

    @RequestMapping(value = "/typeList", method = RequestMethod.GET)
    public List<GoodsType> getGoodsTypeList() {
        return goodsService.getGoodsTypeList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Message deleteGoods(@PathVariable Long id) {
        return goodsService.delete(id);
    }

    @RequestMapping(value = "/updateFood", method = RequestMethod.PUT)
    public Message updateFood(@RequestBody Goods goods) {
        return goodsService.updateGoods(goods);
    }

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    public Message addFood(Goods goods) {
        LOGGER.info("yang" + goods);
        return null;
    }
}
