package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.entity.Shop;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 16:31
 * Description:
 */
public interface IShopService {

    /**
     * 获取商家列表
     *
     * @return
     */
    public List<Shop> getShopList(Page<Shop> page);

    /**
     * 获取商家总数
     *
     * @return
     */
    public Message getShopCount();

    /**
     * 根据Id删除店铺
     *
     * @param id
     * @return
     */
    public Message delete(Long id);
}