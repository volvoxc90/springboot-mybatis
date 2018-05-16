package com.example.service.impl;

import com.example.domain.EquipScrap;
import com.example.mapper.EquipScrapMapper;
import com.example.service.EquipScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipScrapServiceImpl implements EquipScrapService {

    @Autowired
    private EquipScrapMapper equipScrapMapper;
    @Override
    public boolean save(EquipScrap equipScrap) {
        return equipScrapMapper.save(equipScrap);
    }

    @Override
    public boolean update(EquipScrap equipScrap) {
        return equipScrapMapper.update(equipScrap);
    }

    @Override
    public boolean del(Integer id) {
        return equipScrapMapper.del(id);
    }

    @Override
    public List<EquipScrap> find(EquipScrap equipScrap) {
        return equipScrapMapper.find(equipScrap);
    }

}