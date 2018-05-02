package com.example.service.impl;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List getAll2() {
        return userMapper.getAll2();
    }

    @Override
    public List<User> getAll(User user) {
        return userMapper.getAll(user);
    }

    @Override
    public User getUserById(Integer id) {
       User user  = userMapper.getUserById(id);
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateByUser(User user) {
        boolean flag = userMapper.updateByUser(user);
        //int i = 1/0;
        return flag;
    }

    @Override
    public boolean add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }


}