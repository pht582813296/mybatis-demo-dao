package com.it.test;

import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;
import com.it.domain.User;
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

public class MybatiTest {

    private InputStream in ;
    private UserDao userDao;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //sqlSession = sqlSessionFactory.openSession();
        //userDao = sqlSession.getMapper(UserDao.class);
        userDao = new UserDaoImpl(sqlSessionFactory);
    }
    @After
    public void destory() throws IOException {
        in.close();
    }
    @Test
    public  void testFindAll() throws IOException {
        List<User> users =  userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public  void testdelete() throws IOException {
        userDao.deleteUser(51);
    }

    @Test
    public  void testFindUserById() throws IOException {
        User user = userDao.findUserById(48);
        System.out.println(user);
    }
    @Test
    public  void testFindUserByName() throws IOException {
        List<User> user = userDao.findUserByName("王");
        for (User user1 : user) {
            System.out.println(user1);
        }
    }
    @Test
    public  void testFindTotal() throws IOException {
        int total = userDao.findTotal();
        System.out.println(total);
    }


}
