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

    //根据username和sex查询
    public List<User> findByUsernameAdnSex(User user);

    //测试foreach标签
    public List<User> findByIds(User user);

    //测试foreach标签 in
    public List<User> findByIds1(User user);

    //一对多关联查询
    public List<User> findAlls();

    //多对多查询
    public List<User> findManyToMany();

    //一对多延迟加载
    public List<User> findAll1();
}
