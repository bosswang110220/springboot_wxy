package com.wxy.bigdata.mapper;

import com.wxy.bigdata.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Food record);

    Food selectByPrimaryKey(Long id);

    List<Food> selectAll();

    int updateByPrimaryKey(Food record);
}