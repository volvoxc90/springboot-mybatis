package com.example.service;

import com.example.domain.User;

/**
 * @author zhugp
 * @create 2018-03-16 11:47
 **/
public interface UserService {
    public User getUserByName(String name);
}