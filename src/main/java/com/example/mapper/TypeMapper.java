package com.example.mapper;

import com.example.domain.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TypeMapper {

    public boolean save(@Param("typeVO")Type typeVO);

    public boolean update(@Param("typeVO")Type typeVO);

    public Type queryById(@Param("id") Integer id);

    public boolean del(Integer id);

    public List<Type> find(Type typeVO);

    public List<Type> queryAll();
}