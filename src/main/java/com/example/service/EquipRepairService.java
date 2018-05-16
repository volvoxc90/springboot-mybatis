package com.example.service;


import com.example.domain.EquipRepair;

import java.util.List;

public interface EquipRepairService {

    public boolean save(EquipRepair equipRepair);

    public boolean update(EquipRepair equipRepair);

    public boolean del(Integer id);

    public List<EquipRepair> find(EquipRepair equipRepair);

    public Integer queryCount(EquipRepair equipRepair);
}