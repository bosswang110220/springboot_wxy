package com.wxy.bigdata.service;

import com.wxy.bigdata.entity.Category;

import java.util.List;

/**
 * 菜品分类接口
 */
public interface CategoryService {

    int deleteByPrimaryKey(Long id);

    int insert(Category category);

    Category selectByPrimaryKey(Long id);

    List<Category> selectAll();

    int updateByPrimaryKey(Category category);


}
