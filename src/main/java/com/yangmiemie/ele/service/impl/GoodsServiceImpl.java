package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.dao.IGoodsDAO;
import com.yangmiemie.ele.dao.IGoodsTypeDAO;
import com.yangmiemie.ele.entity.Goods;
import com.yangmiemie.ele.entity.GoodsType;
import com.yangmiemie.ele.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-27 14:12
 * Description:
 */
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsDAO goodsDAO;

    @Autowired
    private IGoodsTypeDAO goodsTypeDAO;

    private static final Goods GOODS = new Goods();

    @Override
    public List<Goods> getGoodsList(Page<Goods> page) {
        GOODS.setPages(page);
        return goodsDAO.findList(GOODS);
    }

    @Override
    public Message getGoodsCount(Long shopId) {
        Message msg = new Message();
        GOODS.setShopId(shopId);
        msg.getMap().put("count", goodsDAO.getCount(GOODS));
        return msg;
    }

    @Override
    public List<GoodsType> getGoodsTypeList() {
        return goodsTypeDAO.findList(new GoodsType());
    }

    @Override
    public Message delete(Long id) {
        Message msg = new Message();
        goodsDAO.delete(id);
        return msg;
    }
}
