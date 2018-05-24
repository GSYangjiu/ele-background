package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.dao.IGoodsDAO;
import com.yangmiemie.ele.dao.IGoodsSpecDAO;
import com.yangmiemie.ele.dao.IGoodsTypeDAO;
import com.yangmiemie.ele.entity.Goods;
import com.yangmiemie.ele.entity.GoodsSpec;
import com.yangmiemie.ele.entity.GoodsType;
import com.yangmiemie.ele.service.IGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private IGoodsDAO goodsDAO;

    @Autowired
    private IGoodsTypeDAO goodsTypeDAO;

    @Autowired
    private IGoodsSpecDAO goodsSpecDAO;

    private static final Goods GOODS = new Goods();

    @Override
    public List<Goods> getGoodsList(Page<Goods> page) {
        GOODS.setPages(page);
        List<Goods> goodsList = goodsDAO.findList(GOODS);
        goodsList.forEach(g -> {
            GoodsSpec goodsSpec = new GoodsSpec();
            goodsSpec.setGoodsId(g.getId());
            g.setSpecFoods(goodsSpecDAO.findList(goodsSpec));
        });
        return goodsList;
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

    @Override
    public Message updateGoods(Goods goods) {
        Message msg = new Message();
        try {
            assert goods.getId() != null;
            GoodsSpec goodsSpec = new GoodsSpec();
            goodsSpec.setGoodsId(goods.getId());
            List<GoodsSpec> list = goodsSpecDAO.findList(goodsSpec);
            List<GoodsSpec> goodsSpecList = goods.getSpecFoods();
            goodsSpecList.stream().filter(g -> !list.contains(g)).forEach(g -> goodsSpecDAO.insert(g));
            list.stream().filter(g -> !goodsSpecList.contains(g)).forEach(g -> goodsSpecDAO.deleteSelective(g));
//            //新增规格
//            for (GoodsSpec s : goodsSpecList) {
//                if (!list.contains(s)) {
//                    s.preInsert();
//                    goodsSpecDAO.insert(s);
//                }
//            }
//            //删除规格
//            for (GoodsSpec s : list) {
//                if (!goodsSpecList.contains(s)) {
//                    goodsSpecDAO.deleteSelective(s);
//                }
//            }
            goods.preUpdate();
            goodsDAO.updateSelective(goods);
        } catch (Exception e) {
            msg = new Message(MessageType.M99999);
            logger.error("GoodsServiceImpl updateGoods METHOD ERROR " + e);
        }
        return msg;
    }
}
