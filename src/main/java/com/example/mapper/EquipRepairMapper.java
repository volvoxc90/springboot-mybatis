package com.example.mapper;

import com.example.domain.EquipRepair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipRepairMapper {

    public boolean save(@Param("equipRepair") EquipRepair equipRepair);

    public boolean update(@Param("equipRepair") EquipRepair equipRepair);

    public boolean del(Integer id);

    public List<EquipRepair> find(EquipRepair equipRepair);

   public Integer queryCount(EquipRepair equipRepair);
}