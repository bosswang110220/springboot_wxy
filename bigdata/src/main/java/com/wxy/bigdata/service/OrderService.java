package com.wxy.bigdata.service;

import com.wxy.bigdata.entity.Order;

import java.util.List;

/**
 * @program: bigdata
 * @description: 订单服务类
 * @author: Mr.Wang
 * @create: 2019-07-04 09:21
 **/

public interface OrderService {

    int deleteByPrimaryKey(Long id);

    int insert(Order order);

    Order selectByPrimaryKey(Long id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order order);

}
