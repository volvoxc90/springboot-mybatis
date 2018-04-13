package com.example.mapper;

/**
 * @author zhugp
 * @create 2018-03-16 14:03
 **/

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User getUserByName(String name);

}