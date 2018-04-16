package com.example.service;

import com.example.domain.User;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-16 11:47
 **/
public interface UserService {
    public List<User> getUserByName(String name);

    public List getUsers();
}