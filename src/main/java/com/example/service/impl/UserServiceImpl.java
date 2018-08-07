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
import java.util.Map;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUserByName(User user) {
        return userMapper.getUserByName(user);
    }

    @Override
    public User getUser(String userName, String password) {
        return userMapper.getUser(userName, password);
    }

    @Override
    public List queryAll() {
        return userMapper.queryAll();
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
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public boolean updatePwd(String password, Integer id) {
        return userMapper.updatePwd(password, id);
    }

    @Override
    public Map<String, String> selectCount(User user) {
        return userMapper.searchCount(user);
    }


}