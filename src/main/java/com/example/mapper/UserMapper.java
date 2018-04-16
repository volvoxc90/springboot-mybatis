package com.example.mapper;

/**
 * @author zhugp
 * @create 2018-03-16 14:03
 **/

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> getUserByName(@Param("username") String username);

    public List getUsers();
}