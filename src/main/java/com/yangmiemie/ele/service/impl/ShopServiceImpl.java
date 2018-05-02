package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.common.utils.MessageType;
import com.yangmiemie.ele.common.utils.Page;
import com.yangmiemie.ele.common.vo.ShopCategory;
import com.yangmiemie.ele.dao.ICategoriesDAO;
import com.yangmiemie.ele.dao.IShopDAO;
import com.yangmiemie.ele.entity.Categories;
import com.yangmiemie.ele.entity.Shop;
import com.yangmiemie.ele.service.IShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-22 16:32
 * Description:
 */
@Service("shopService")
public class ShopServiceImpl implements IShopService {

    private final static Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private IShopDAO shopDAO;

    @Autowired
    private ICategoriesDAO categoriesDAO;

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

    @Override
    public Message updateShop(Shop shop) {
        Message msg = new Message();
        try {
            shopDAO.updateSelective(shop);
        } catch (Exception e) {
            msg = new Message(MessageType.M99999);
            logger.error("ShopServiceImpl updateShop METHOD ERROR " + e);
        }
        return msg;
    }

    @Override
    public List<ShopCategory> getCategories(Integer id) {
        List<ShopCategory> foodCategoryList = new ArrayList<>();
        List<Categories> list = categoriesDAO.findListByParentNum(id);
        for (Categories item : list) {
            List<Categories> child = categoriesDAO.findListByParentNum(item.getNum());

            //填充 FoodCategoryList,二级菜单，向下迭代一层
            ShopCategory foodCategory = new ShopCategory();
            foodCategory.setCategories(item);
            foodCategory.setChild(child);
            foodCategoryList.add(foodCategory);
        }
        return foodCategoryList;
    }
}
