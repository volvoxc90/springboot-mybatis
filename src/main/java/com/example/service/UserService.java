package com.example.service;

import com.example.domain.User;
import com.example.utils.MyMapper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @create 2018-03-16 11:47
 **/
public interface UserService {

    public User getUserByName(String userName);

    public User getUser(String userName, String password);

    public List queryAll();

    public User getUserById(Integer id);

    public Boolean updateByUser(User user);

    public boolean add(User user);

    public boolean deleteById(Integer id);

    public boolean updatePwd(String password, Integer id);

}