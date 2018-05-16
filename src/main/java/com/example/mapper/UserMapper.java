package com.example.mapper;


import com.example.domain.User;
import com.example.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserMapper extends MyMapper {

    public User getUserByName(@Param("userName") String userName);

    public User getUser(@Param("userName")String userName, @Param("password")String password);

    public List queryAll();

    public User getUserById(@Param("id") Integer id);

    public Boolean updateByUser(@Param("user") User user);

    public boolean add(@Param("user") User user);

    public boolean deleteById(Integer id);

    public boolean updatePwd(@Param("password") String password, @Param("id") Integer id);

}