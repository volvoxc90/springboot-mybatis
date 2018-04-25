package com.facility.mapper;

import com.facility.domain.TabletPC;

public interface TabletPCMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TabletPC record);

    int insertSelective(TabletPC record);

    TabletPC selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TabletPC record);

    int updateByPrimaryKey(TabletPC record);
}