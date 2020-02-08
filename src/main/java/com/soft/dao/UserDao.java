package com.soft.dao;

import com.soft.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2020/2/8.
 */
public interface UserDao {
    public List<User> findAll();
}
