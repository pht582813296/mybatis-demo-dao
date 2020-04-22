package com.it.dao.impl;

import com.it.dao.UserDao;
import com.it.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.it.dao.UserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {

    }

    public User findUserById(Integer id) {
        return null;
    }

    public List<User> findUserByName(String username) {
        return null;
    }

    public int findTotal() {
        return 0;
    }
}
