package com.wxy.bigdata.service;

import com.wxy.bigdata.entity.User;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);


}
