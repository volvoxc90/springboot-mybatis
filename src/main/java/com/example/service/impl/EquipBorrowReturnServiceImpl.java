package com.example.service.impl;

import com.example.domain.EquipBorrowReturn;
import com.example.mapper.EquipBorrowReturnMapper;
import com.example.service.EquipBorrowReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipBorrowReturnServiceImpl implements EquipBorrowReturnService {

    @Autowired
    private EquipBorrowReturnMapper equipBorrowReturnMapper;
    @Override
    public boolean save(EquipBorrowReturn equipBorrowReturn) {
        return equipBorrowReturnMapper.save(equipBorrowReturn);
    }

    @Override
    public boolean update(EquipBorrowReturn equipBorrowReturn) {
        return equipBorrowReturnMapper.update(equipBorrowReturn);
    }

    @Override
    public boolean del(Integer id) {
        return equipBorrowReturnMapper.del(id);
    }

    @Override
    public List<EquipBorrowReturn> findBorrows(EquipBorrowReturn equipBorrowReturn) {
        return equipBorrowReturnMapper.findBorrows(equipBorrowReturn);
    }
    @Override
    public List<EquipBorrowReturn> findReturns(EquipBorrowReturn equipBorrowReturn) {
        return equipBorrowReturnMapper.findReturns(equipBorrowReturn);
    }

    @Override
    public boolean giveBack(EquipBorrowReturn equipBorrowReturn) {
        return equipBorrowReturnMapper.giveBack(equipBorrowReturn);
    }

    @Override
    public boolean borrow(EquipBorrowReturn equipBorrowReturn) {
        return equipBorrowReturnMapper.borrow(equipBorrowReturn);
    }

    @Override
    public Integer queryCount(EquipBorrowReturn equipBorrowReturn) {
        return equipBorrowReturnMapper.queryCount(equipBorrowReturn);
    }
}