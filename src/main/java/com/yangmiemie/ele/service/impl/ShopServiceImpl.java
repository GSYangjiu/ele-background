package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.dao.IShopDAO;
import com.yangmiemie.ele.entity.Shop;
import com.yangmiemie.ele.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 16:32
 * Description:
 */
@Service("shopService")
public class ShopServiceImpl implements IShopService {
    @Autowired
    private IShopDAO shopDAO;

    private static final Shop SHOP = new Shop();

    @Override
    public List<Shop> getShopList(Page<Shop> page) {
        SHOP.setPages(page);
        return shopDAO.findList(SHOP);
    }

    @Override
    public Message getShopCount() {
        Message msg = new Message();
        msg.getMap().put("count", shopDAO.getCount(SHOP));
        return msg;
    }

    @Override
    public Message delete(Long id) {
        Message msg = new Message();
        shopDAO.delete(id);
        return msg;
    }
}
