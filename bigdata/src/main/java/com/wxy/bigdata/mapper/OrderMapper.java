package com.wxy.bigdata.mapper;

import com.wxy.bigdata.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    Order selectByPrimaryKey(Long id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}