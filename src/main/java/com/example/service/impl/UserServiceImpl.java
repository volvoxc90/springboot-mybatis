package com.example.service.impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-16 11:47
 **/
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public List getUsers() {
        return userMapper.getUsers();
    }
}