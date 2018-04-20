package com.example.mapper;

/**
 * @author zhugp
 * @create 2018-03-16 14:03
 **/

import com.example.domain.User;
import com.example.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends MyMapper {

    public List<User> getUserByName(@Param("username") String username);

    public List getAll2();

    public List<User> getAll(@Param("user") User user);

    public List<User> getUserByAge(@Param("age") Integer age);

    public Boolean updateByUser(@Param("user") User user);

    public boolean add(@Param("user") User user);

    public int deleteById(Integer id);

    public List<User> findByUserNameLike(@Param("user") User user);
}