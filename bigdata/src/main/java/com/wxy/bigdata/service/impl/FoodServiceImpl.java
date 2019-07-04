package com.wxy.bigdata.service.impl;

import com.wxy.bigdata.entity.Food;
import com.wxy.bigdata.mapper.FoodMapper;
import com.wxy.bigdata.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bigdata
 * @description: 菜品实现类
 * @author: Mr.Wang
 * @create: 2019-07-04 09:07
 **/

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private  FoodMapper foodMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return foodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Food food) {
        return foodMapper.insert(food);
    }

    @Override
    public Food selectByPrimaryKey(Long id) {
        return foodMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Food> selectAll() {
        return foodMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Food food)
    {
        return foodMapper.updateByPrimaryKey(food);
    }
}
