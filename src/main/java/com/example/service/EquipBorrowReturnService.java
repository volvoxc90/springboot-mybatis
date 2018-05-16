package com.example.service;


import com.example.domain.EquipBorrowReturn;

import java.util.List;

public interface EquipBorrowReturnService {
    public boolean save(EquipBorrowReturn equipBorrowReturn);

    public boolean update(EquipBorrowReturn equipBorrowReturn);

    public boolean del(Integer id);

    public List<EquipBorrowReturn> findBorrows(EquipBorrowReturn equipBorrowReturn);

    public List<EquipBorrowReturn> findReturns(EquipBorrowReturn equipBorrowReturn);

    public boolean giveBack(EquipBorrowReturn equipBorrowReturn);

    public boolean borrow(EquipBorrowReturn equipBorrowReturn);

    public Integer queryCount(EquipBorrowReturn equipBorrowReturn);
}