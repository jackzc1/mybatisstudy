package com.soft.test;

import com.soft.dao.UserDao;
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
import java.util.List;

/**
 * Created by Administrator on 2020/2/9.
 */
public class Demo3 {
    private InputStream inputStream = null;
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;
    private UserDao userDao = null;
    @Before
    public void init() {
        try {
            inputStream = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
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
        User user = new User();
        user.setUsername("%熊%");
        user.setSex("%女%");
        List<User> li = userDao.findByUsernameAdnSex(user);
        for (User user1 : li) {
            System.out.println(user1);
        }
    }


    @Test
    public void test2() {
        User user = new User();
        int[] ids = {1,2,3};
        user.setIds(ids);
        List<User> li = userDao.findByIds(user);
        for (User user1 : li) {
            System.out.println(user1);
        }
    }

    @Test
    public void test3() {
        User user = new User();
        int[] ids = {1,2,3};
        user.setIds(ids);
        List<User> li = userDao.findByIds1(user);
        for (User user1 : li) {
            System.out.println(user1);
        }
    }
}
