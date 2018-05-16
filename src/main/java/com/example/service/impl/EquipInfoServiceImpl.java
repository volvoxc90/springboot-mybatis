package com.example.service.impl;

import com.example.domain.EquipInfoVO;
import com.example.domain.StatusVO;
import com.example.mapper.EquipInfoMapper;
import com.example.service.EquipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @create 2018-04-29 17:42
 **/
@Service
@Transactional
public class EquipInfoServiceImpl implements EquipInfoService {
    @Autowired
    private EquipInfoMapper equipInfoMapper;

    @Override
    public boolean save(EquipInfoVO equipInfoVO) {
        return equipInfoMapper.save(equipInfoVO);
    }

    @Override
    public boolean update(EquipInfoVO equipInfoVO) {
        return equipInfoMapper.update(equipInfoVO);
    }

    @Override
    public boolean updateStatus(EquipInfoVO equipInfoVO) {
        return equipInfoMapper.updateStatus(equipInfoVO);
    }

    @Override
    public boolean delById(Integer id) {
        return equipInfoMapper.delById(id);
    }

    @Override
    public List<EquipInfoVO> find(EquipInfoVO equipInfoVO) {
        return equipInfoMapper.find(equipInfoVO);
    }

    @Override
    public List<EquipInfoVO> queryAll() {
        return equipInfoMapper.queryAll();
    }

    @Override
    public EquipInfoVO queryById(Integer id) {
        return equipInfoMapper.queryById(id);
    }

    @Override
    public List<StatusVO> queryAllStatus() {
        return equipInfoMapper.queryAllStatus();
    }

}