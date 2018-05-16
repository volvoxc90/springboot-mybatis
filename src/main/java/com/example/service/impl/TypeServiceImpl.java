package com.example.service.impl;

import com.example.domain.Type;
import com.example.mapper.TypeMapper;
import com.example.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public boolean save(Type typeV0) {
        return typeMapper.save(typeV0);
    }

    @Override
    public boolean update(Type typeV0) {
        return typeMapper.update(typeV0);
    }

    @Override
    public boolean del(Integer id) {
        return typeMapper.del(id);
    }

    @Override
    public List<Type> find(Type typeVO) {
        return typeMapper.find(typeVO);
    }

    @Override
    public Type queryById(Integer id) {
        return typeMapper.queryById(id);
    }

    @Override
    public List<Type> queryAll() {
        return typeMapper.queryAll();
    }
}