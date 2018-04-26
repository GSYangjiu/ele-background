package com.yangmiemie.ele.dao;

import com.yangmiemie.ele.common.dao.CurdDAO;
import com.yangmiemie.ele.entity.Categories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-24 16:27
 * Description:
 */
@Mapper
public interface ICategoriesDAO extends CurdDAO<Categories> {

    public List<Categories> findListByParentNum(Integer id);
}
