package com.wxy.bigdata.mapper;

import com.wxy.bigdata.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Shop record);

    Shop selectByPrimaryKey(Long id);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop record);
}