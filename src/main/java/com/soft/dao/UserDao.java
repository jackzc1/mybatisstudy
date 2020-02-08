package com.soft.dao;

import com.soft.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2020/2/8.
 */
public interface UserDao {
    public List<User> findAll();
    //新增
    public void insert(User user);
    //删除
    public void deleteById(Integer id);
    //修改
    public void update(User user);
    //根据id查询
    public User findById(Integer id);
    //模糊查询
    public List<User> findByName(String name);

}
