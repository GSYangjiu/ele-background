package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.common.vo.FoodCategory;
import com.yangmiemie.ele.entity.Categories;
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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Shop> getShopList(Page<Shop> page) {
        return shopService.getShopList(page);
    }

    @ApiOperation(value = "获取商家总数")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Message getShopCount() {
        return shopService.getShopCount();
    }


    @ApiOperation(value = "修改商家信息")
    @ApiImplicitParam(name = "shop", value = "shop", required = true, dataType = "Shop")
    @RequestMapping(value = "/updateShop", method = RequestMethod.PUT)
    public Message updateShop(@RequestBody Shop shop) {
        return shopService.update(shop);
    }

    @ApiOperation(value = "删除商家", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "商铺ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Message deleteShop(@PathVariable Long id) {
        return shopService.delete(id);
    }

    @ApiOperation(value = "获取商铺分类")
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<FoodCategory> getFoodCategory(@RequestParam(value = "id", required = false, defaultValue = "1000") Integer id) {
        return shopService.getCategories(id);
    }
}
