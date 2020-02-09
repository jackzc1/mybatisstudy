package com.soft.test;

import com.soft.dao.UserDao;
import com.soft.dao.UserDao1;
import com.soft.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/2/9.
 */
public class Demo5 {
    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private UserDao1 userDao1 = null;
    @Before
    public void init() {
        try {
            inputStream = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao1 = sqlSession.getMapper(UserDao1.class);
    }
    @After
    public void destory() {
        sqlSession.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        User user = userDao1.findById(1);
        System.out.println(user);
    }

    @Test
    public void test2() {
        User user = new User();
        user.setUsername("小雅");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("江西");
        userDao1.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void test3() {
        User user = new User();
        user.setId(7);
        user.setUsername("小雅");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("江西1");
        userDao1.updateUser(user);
        sqlSession.commit();
    }

    //测试2机缓存
    @Test
    public void test4() {
        User byId1 = userDao1.findById(1);
        System.out.println(byId1);
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();
        UserDao1 mapper = sqlSession.getMapper(UserDao1.class);
        User byId11 = mapper.findById(1);
        System.out.println(byId11);
    }

    //测试一对多延迟加载
    @Test
    public void test5() {
        User user = userDao1.findByid1(2);
        System.out.println(user.getUsername());
        System.out.println(user.getAccounts());

    }
}
