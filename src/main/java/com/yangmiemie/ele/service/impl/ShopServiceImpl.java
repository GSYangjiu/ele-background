package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.common.service.impl.CrudServiceImpl;
import com.yangmiemie.ele.common.vo.ShopCategory;
import com.yangmiemie.ele.dao.ICategoriesDAO;
import com.yangmiemie.ele.dao.IShopDAO;
import com.yangmiemie.ele.entity.Categories;
import com.yangmiemie.ele.entity.Shop;
import com.yangmiemie.ele.service.IShopService;
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
public class ShopServiceImpl extends CrudServiceImpl<IShopDAO, Shop> implements IShopService {

    @Autowired
    private ICategoriesDAO categoriesDAO;

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
