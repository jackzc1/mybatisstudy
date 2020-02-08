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
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/2/8.
 */
public class Demo2 {
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
    public void testFindById(){
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "萌萌", new Date(), "女", "地球");
        userDao.insert(user);
        sqlSession.commit();
    }
    @Test
    public void testDeleteById() {
        userDao.deleteById(5);
        sqlSession.commit();
    }
    @Test
    public void testUpdate() {
        User user = new User(6, "萌萌", new Date(), "女", "地球1");
        userDao.update(user);
        sqlSession.commit();
    }
    @Test
    public void testFindByName() {
        List<User> li = userDao.findByName("%熊%");
        for (User user : li) {
            System.out.println(user);
        }
    }
}
