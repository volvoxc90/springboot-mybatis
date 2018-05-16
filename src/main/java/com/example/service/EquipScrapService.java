package com.example.service;


import com.example.domain.EquipScrap;

import java.util.List;

public interface EquipScrapService {

    public boolean save(EquipScrap equipScrap);

    public boolean update(EquipScrap equipScrap);

    public boolean del(Integer id);

    public List<EquipScrap> find(EquipScrap equipScrap);
}