package com.example.service;

import com.example.domain.EquipVO;

import java.util.List;

/**
 * @create 2018-04-29 15:34
 **/
public interface EquipService {

    public boolean save(EquipVO equipVO);

    public boolean update(EquipVO equipVO);

    public boolean delById(Integer id);

    public List<EquipVO> find(EquipVO equipVO);
}