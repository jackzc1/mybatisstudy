package com.soft.test;

import com.soft.dao.UserDao;
import com.soft.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2020/2/8.
 */
public class Demo1 {
    @Test
    public void testFindAll() throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
        inputStream.close();

    }

}
