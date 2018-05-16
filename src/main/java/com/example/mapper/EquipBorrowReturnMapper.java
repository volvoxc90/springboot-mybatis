package com.example.mapper;


import com.example.domain.EquipBorrowReturn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EquipBorrowReturnMapper {
    public boolean save(@Param("equipBorrowReturn") EquipBorrowReturn equipBorrowReturn);

    public boolean update(@Param("equipBorrowReturn") EquipBorrowReturn equipBorrowReturn);

    public boolean del(@Param("id")Integer id);

    public List<EquipBorrowReturn> findBorrows(EquipBorrowReturn equipBorrowReturn);

    public List<EquipBorrowReturn> findReturns(EquipBorrowReturn equipBorrowReturn);

    public boolean giveBack(@Param("equipBorrowReturn") EquipBorrowReturn equipBorrowReturn);

    public boolean borrow(@Param("equipBorrowReturn") EquipBorrowReturn equipBorrowReturn);

    public Integer queryCount(EquipBorrowReturn equipBorrowReturn);
}