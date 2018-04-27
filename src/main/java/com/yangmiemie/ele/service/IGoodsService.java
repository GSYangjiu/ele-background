package com.yangmiemie.ele.service;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.entity.Goods;
import com.yangmiemie.ele.entity.GoodsType;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-27 14:11
 * Description:
 */
public interface IGoodsService {

    /**
     * 获取商品列表
     *
     * @param page
     * @return List
     */
    public List<Goods> getGoodsList(Page<Goods> page);

    /**
     * 获取商品总数
     *
     * @param shopId
     * @return Message
     */
    public Message getGoodsCount(Long shopId);

    /**
     * 获取商品分类列表
     *
     * @return List
     */
    public List<GoodsType> getGoodsTypeList();

    /**
     * 删除商品
     *
     * @return Message
     */
    public Message delete(Long id);
}
