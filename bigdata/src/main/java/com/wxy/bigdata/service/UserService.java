package com.wxy.bigdata.service;

import com.wxy.bigdata.entity.User;

import java.util.List;

public interface UserService {

    User selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
