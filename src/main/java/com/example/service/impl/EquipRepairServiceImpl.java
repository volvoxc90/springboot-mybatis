package com.example.service.impl;

import com.example.domain.EquipRepair;
import com.example.mapper.EquipRepairMapper;
import com.example.service.EquipRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipRepairServiceImpl implements EquipRepairService {

    @Autowired
    private EquipRepairMapper equipRepairMapper;
    @Override
    public boolean save(EquipRepair equipRepair) {
        return equipRepairMapper.save(equipRepair);
    }

    @Override
    public boolean update(EquipRepair equipRepair) {
        return equipRepairMapper.update(equipRepair);
    }

    @Override
    public boolean del(Integer id) {
        return equipRepairMapper.del(id);
    }

    @Override
    public List<EquipRepair> find(EquipRepair equipRepair) {
        return equipRepairMapper.find(equipRepair);
    }

    @Override
    public Integer queryCount(EquipRepair equipRepair) {
        return equipRepairMapper.queryCount(equipRepair);
    }
}