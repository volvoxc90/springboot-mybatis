package com.example.mapper;

import com.example.domain.EquipInfoVO;
import com.example.domain.StatusVO;
import com.example.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface EquipInfoMapper extends MyMapper {

    public boolean save(@Param("equipInfoVO")EquipInfoVO equipInfoVO);

    public boolean update(@Param("equipInfoVO")EquipInfoVO equipInfoVO);

    public boolean delById(@Param("id")int id);

    public List<EquipInfoVO> find(EquipInfoVO equipInfoVO);

    public List<EquipInfoVO> queryAll();

    public EquipInfoVO queryById(@Param("id")Integer id);

    public boolean updateStatus(@Param("equipInfoVO")EquipInfoVO equipInfoVO);

    public List<StatusVO> queryAllStatus();

    public Integer queryAllStatus2();
    public Integer queryAllStatus3();
    public Integer queryAllStatus4();
}