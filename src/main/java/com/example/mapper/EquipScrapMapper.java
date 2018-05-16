package com.example.mapper;

import com.example.domain.EquipScrap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipScrapMapper {

    public boolean save(@Param("equipScrap") EquipScrap equipScrap);

    public boolean update(@Param("equipScrap")EquipScrap equipScrap);

    public boolean del(Integer id);

    public List<EquipScrap> find(EquipScrap equipScrap);
}