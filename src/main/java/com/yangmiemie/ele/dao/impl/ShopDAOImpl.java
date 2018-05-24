package com.yangmiemie.ele.dao.impl;

import com.yangmiemie.ele.common.dao.impl.MGCurdDAOImpl;
import com.yangmiemie.ele.dao.IShopDAO;
import com.yangmiemie.ele.entity.Shop;
import org.springframework.stereotype.Repository;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-24 11:33
 * Description:
 */
@Repository("shopDao")
public class ShopDAOImpl extends MGCurdDAOImpl<Shop> implements IShopDAO {
}
