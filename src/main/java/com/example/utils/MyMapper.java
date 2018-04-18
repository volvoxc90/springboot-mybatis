package com.example.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zhugp
 * @create 2018-04-17 12:45
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}