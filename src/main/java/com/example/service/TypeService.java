package com.example.service;


import com.example.domain.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeService {

    public boolean save(Type typeV0);

    public boolean update(Type typeV0);

    public boolean del(Integer id);

    public List<Type> find(Type typeVO);

    public List<Type> queryAll();

    public Type queryById(Integer id);
}