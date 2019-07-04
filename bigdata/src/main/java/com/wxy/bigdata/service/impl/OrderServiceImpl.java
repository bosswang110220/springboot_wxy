package com.wxy.bigdata.service.impl;

import com.wxy.bigdata.entity.Order;
import com.wxy.bigdata.mapper.OrderMapper;
import com.wxy.bigdata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bigdata
 * @description: 订单实现类
 * @author: Mr.Wang
 * @create: 2019-07-04 09:22
 **/

@Service
public class OrderServiceImpl implements OrderService {

@Autowired
    private OrderMapper orderMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Order order) {
        return orderMapper.updateByPrimaryKey(order);
    }
}
