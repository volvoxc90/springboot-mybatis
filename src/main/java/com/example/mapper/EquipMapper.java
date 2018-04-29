package com.example.mapper;

import com.example.domain.EquipVO;
import com.example.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @create 2018-04-29 16:26
 **/
@Mapper
public interface EquipMapper extends MyMapper {

    public boolean save(EquipVO equipVO);

    public boolean update(EquipVO equipVO);

    public boolean delById(int id);

    public List<EquipVO> find(EquipVO equipVO);

}