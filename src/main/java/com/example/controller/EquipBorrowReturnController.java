package com.example.controller;

import com.example.domain.EquipBorrowReturn;
import com.example.domain.EquipInfoVO;
import com.example.domain.EquipScrap;
import com.example.service.EquipBorrowReturnService;
import com.example.service.EquipInfoService;
import com.example.utils.WebResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipBorrowReturnController {

    @Autowired
    private EquipBorrowReturnService equipBorrowReturnService;

    @Autowired
    private EquipInfoService equipInfoService;

    @ApiOperation(value = "借还新增", notes = "借还新增")
    @ApiImplicitParam(name = "equipBorrowReturn", value = "equipBorrowReturn", required = true, dataType = "equipBorrowReturn")
    @RequestMapping(value = "/borrow/save", method = RequestMethod.POST)
    public WebResult<EquipScrap> save(EquipBorrowReturn equipBorrowReturn) {
        try {
            boolean flag = equipBorrowReturnService.save(equipBorrowReturn);
            if(flag)
                return new WebResult("success", "新增成功");
            return new WebResult("failed", "新增失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "借还修改", notes = "借还修改")
    @ApiImplicitParam(name = "equipBorrowReturn", value = "equipBorrowReturn", required = true, dataType = "equipBorrowReturn")
    @RequestMapping(value = "/borrow/update", method = RequestMethod.POST)
    public WebResult<EquipScrap> update(EquipBorrowReturn equipBorrowReturn) {
        try {
            boolean flag = equipBorrowReturnService.update(equipBorrowReturn);
            if(flag)
                return new WebResult("success", "修改成功");
            return new WebResult("failed", "修改失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }

    }
    @ApiOperation(value = "借还删除", notes = "借还删除")
    @ApiImplicitParam(name = "id", value = "根据id删除", required = true, dataType = "Integer")
    @RequestMapping(value = "/borrow/del", method = RequestMethod.GET)
    public WebResult<EquipScrap> del(Integer id) {
        try {
            boolean flag = equipBorrowReturnService.del(id);
            if(flag)
                return new WebResult("success", "删除成功");
            return new WebResult("failed", "删除失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }


    @ApiOperation(value = "查找借出", notes = "根据名称，类型，日期等查询")
    @ApiImplicitParam(name = "equipBorrowReturn", value = "借出对象", required = true, dataType = "equipBorrowReturn")
    @RequestMapping(value = "/borrow/findBorrows", method = RequestMethod.GET)
    public WebResult<EquipBorrowReturn> findBorrows(EquipBorrowReturn equipBorrowReturn) {
        WebResult result = new WebResult<EquipBorrowReturn>();
        PageHelper.startPage(1, 1000);
        try {
            List<EquipBorrowReturn> list =  equipBorrowReturnService.findBorrows(equipBorrowReturn);
            PageInfo<EquipBorrowReturn> pageInfo = new PageInfo<EquipBorrowReturn>(list);
            result.setCode("success");
            result.setData(pageInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("failed");
            result.setData(e.getClass().getName());
            return result;
        }
    }

    @ApiOperation(value = "查找归还", notes = "根据名称，类型，日期等查询")
    @ApiImplicitParam(name = "equipBorrowReturn", value = "归还对象", required = true, dataType = "equipBorrowReturn")
    @RequestMapping(value = "/borrow/findReturns", method = RequestMethod.GET)
    public WebResult<EquipBorrowReturn> findReturns(EquipBorrowReturn equipBorrowReturn) {
        WebResult result = new WebResult<EquipBorrowReturn>();
        PageHelper.startPage(1, 1000);
        try {
            List<EquipBorrowReturn> list =  equipBorrowReturnService.findReturns(equipBorrowReturn);
            PageInfo<EquipBorrowReturn> pageInfo = new PageInfo<EquipBorrowReturn>(list);
            result.setCode("success");
            result.setData(pageInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("failed");
            result.setData(e.getClass().getName());
            return result;
        }
    }

    @ApiOperation(value = "归还", notes = "归还")
    @ApiImplicitParam(name = "id", value = "根据id归还", required = true, dataType = "Integer")
    @RequestMapping(value = "/borrow/giveBack", method = RequestMethod.POST)
    public WebResult<EquipBorrowReturn> giveBack(EquipBorrowReturn equipBorrowReturn) {
        try {
            boolean flag = equipBorrowReturnService.update(equipBorrowReturn);
            EquipInfoVO equipInfoVO = equipInfoService.queryById(equipBorrowReturn.getEquipInfoId());
            if (equipInfoVO == null) return new WebResult("failed", "请检查equipInfoId是否有值");
            if(flag) {
                equipInfoVO.setStatus(1);
                equipInfoService.updateStatus(equipInfoVO);
                return new WebResult("success", "归还成功");
            }
            return new WebResult("failed", "归还失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "借出", notes = "借出")
    @ApiImplicitParam(name = "id", value = "根据id借出", required = true, dataType = "Integer")
    @RequestMapping(value = "/borrow/borrow", method = RequestMethod.POST)
    public WebResult<EquipBorrowReturn> borrow(EquipBorrowReturn equipBorrowReturn) {
        try {
            boolean flag = equipBorrowReturnService.borrow(equipBorrowReturn);
            EquipInfoVO equipInfoVO = equipInfoService.queryById(equipBorrowReturn.getEquipInfoId());
            if (equipInfoVO == null) return new WebResult("failed", "请检查equipInfoId是否有值");
            if(flag) {
                equipInfoVO.setStatus(4);
                equipInfoService.updateStatus(equipInfoVO);
                return new WebResult("success", "借出成功");
            }
            return new WebResult("failed", "借出失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }
}