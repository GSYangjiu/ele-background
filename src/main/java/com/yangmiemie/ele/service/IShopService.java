package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.service.ICrudService;
import com.yangmiemie.ele.common.vo.ShopCategory;
import com.yangmiemie.ele.dao.IShopDAO;
import com.yangmiemie.ele.entity.Shop;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 16:31
 * Description:
 */
public interface IShopService extends ICrudService<IShopDAO, Shop> {


    /**
     * 根据id获取分类
     *
     * @param id 分类id
     * @return List实体
     */
    List<ShopCategory> getCategories(Integer id);
}
