package com.wxy.bigdata.service.impl;

import com.wxy.bigdata.entity.Shop;
import com.wxy.bigdata.mapper.ShopMapper;
import com.wxy.bigdata.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bigdata
 * @description: 商家实现类
 * @author: Mr.Wang
 * @create: 2019-07-04 09:23
 **/

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return shopMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Shop shop) {
        return shopMapper.insert(shop);
    }

    @Override
    public Shop selectByPrimaryKey(Long id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Shop> selectAll() {
        return shopMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Shop shop) {
        return shopMapper.updateByPrimaryKey(shop);
    }
}
