package com.example.service.impl;

import com.example.domain.EquipVO;
import com.example.mapper.EquipMapper;
import com.example.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2018-04-29 17:42
 **/
@Service
public class EquipServiceImpl implements EquipService {
    @Autowired
    private EquipMapper equipMapper;

    @Override
    public boolean save(EquipVO equipVO) {
        return equipMapper.save(equipVO);
    }

    @Override
    public boolean update(EquipVO equipVO) {
        return equipMapper.update(equipVO);
    }

    @Override
    public boolean delById(Integer id) {
        return equipMapper.delById(id);
    }

    @Override
    public List<EquipVO> find(EquipVO equipVO) {
        return equipMapper.find(equipVO);
    }
}