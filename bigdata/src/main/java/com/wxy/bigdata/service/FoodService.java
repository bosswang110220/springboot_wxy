package com.wxy.bigdata.service;

import com.wxy.bigdata.entity.Food;

import java.util.List;

/**
 * @program: bigdata
 * @description: 菜品服务接口
 * @author: Mr.Wang
 * @create: 2019-07-04 08:57
 **/

public interface FoodService {

    int deleteByPrimaryKey(Long id);

    int insert(Food food);

    Food selectByPrimaryKey(Long id);

    List<Food> selectAll();

    int updateByPrimaryKey(Food food);


}
