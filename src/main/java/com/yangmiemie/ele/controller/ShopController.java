package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.entity.Shop;
import com.yangmiemie.ele.service.IShopService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 16:30
 * Description:
 */
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IShopService shopService;

    @ApiOperation(value = "获取商家列表")
    @ApiImplicitParam(name = "shopList", value = "offset&limit", required = true, dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Shop> getShopList(Page<Shop> page) {
        return shopService.getShopList(page);
    }

    @ApiOperation(value = "获取商家总数")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getShopCount() {
        return shopService.getShopCount();
    }

    @ApiOperation(value = "删除商家", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "商铺ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Message deleteShop(@PathVariable Long id) {
        return shopService.delete(id);
    }
}