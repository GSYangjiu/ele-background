package com.yangmiemie.ele.controller;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.common.vo.ShopCategory;
import com.yangmiemie.ele.entity.Shop;
import com.yangmiemie.ele.service.IShopService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/list")
    public List<Shop> getShopList(Pageable page) {
        return shopService.findByPage(page);
    }

    @GetMapping("/count")
    public Message getShopCount(Shop shop) {
        return shopService.getCount(shop);
    }

    @PutMapping("/updateShop")
    public Message updateShop(@RequestBody Shop shop) {
        return shopService.update(shop);
    }

    @DeleteMapping("/{id}")
    public Message deleteShop(@PathVariable Long id) {
        return shopService.delete(id);
    }

    @GetMapping("/category")
    public List<ShopCategory> getFoodCategory(@RequestParam(value = "id", required = false, defaultValue = "1000") Integer id) {
        return shopService.getCategories(id);
    }

    @PostMapping("/addShop")
    public Message addShop(@RequestBody Shop shop) {
        return shopService.add(shop);
    }

    @GetMapping("/{id}")
    public Shop getShopDetail(@PathVariable Long id) {
        return shopService.getDetail(id);
    }
}