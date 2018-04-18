package com.example.service;

import com.example.domain.User;
import com.example.utils.MyMapper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-16 11:47
 **/
public interface UserService {
    public List<User> getUserByName(String name);

    public List getUsers();

    public List<User> getAll(User user);

    public List<User> getUserByAge(Integer age);
}