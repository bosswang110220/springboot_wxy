package com.wxy.bigdata.service.impl;

import com.wxy.bigdata.entity.Category;
import com.wxy.bigdata.mapper.CategoryMapper;
import com.wxy.bigdata.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bigdata
 * @description: 菜品分类实现类
 * @author: Mr.Wang
 * @create: 2019-07-04 09:20
 **/

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Category selectByPrimaryKey(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }
}
