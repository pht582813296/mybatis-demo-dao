package com.it.dao;

import com.it.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void saveUser (User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findUserById(Integer id);
    List<User> findUserByName(String username);
    int findTotal();
}
