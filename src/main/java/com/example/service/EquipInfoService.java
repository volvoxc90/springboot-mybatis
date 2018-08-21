package com.example.service;

import com.example.domain.EquipInfoVO;
import com.example.domain.StatusVO;

import java.util.List;


public interface EquipInfoService {

    public boolean save(EquipInfoVO equipInfoVO);

    public boolean update(EquipInfoVO equipInfoVO);

    public boolean updateStatus(EquipInfoVO equipInfoVO);

    public boolean delById(Integer id);

    public List<EquipInfoVO> find(EquipInfoVO equipInfoVO);

    public List<EquipInfoVO> queryAll();

    public EquipInfoVO queryById(Integer id);

    public List<StatusVO> queryAllStatus();

    public List<EquipInfoVO> queryEquipInfoByUser(EquipInfoVO equipInfoVO);
}