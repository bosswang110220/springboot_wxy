package com.wxy.bigdata.service;

import com.wxy.bigdata.entity.Shop;

import java.util.List;

public interface ShopService {

    int deleteByPrimaryKey(Long id);

    int insert(Shop shop);

    Shop selectByPrimaryKey(Long id);

    List<Shop> selectAll();

    int updateByPrimaryKey(Shop shop);

}
