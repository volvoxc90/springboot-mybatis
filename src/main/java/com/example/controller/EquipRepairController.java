package com.example.controller;

import com.example.domain.EquipInfoVO;
import com.example.domain.EquipRepair;
import com.example.domain.EquipScrap;
import com.example.service.EquipInfoService;
import com.example.service.EquipRepairService;
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
public class EquipRepairController {

    @Autowired
    private EquipRepairService equipRepairService;

    @Autowired
    private EquipInfoService equipInfoService;

    @ApiOperation(value = "设备维修新增", notes = "设备维修新增")
    @ApiImplicitParam(name = "equipRepair", value = "维修对象equipRepair", required = true, dataType = "equipRepair")
    @RequestMapping(value = "/repair/save", method = RequestMethod.POST)
    public WebResult<EquipRepair> save(EquipRepair equipRepair) {
        try {
            boolean flag = equipRepairService.save(equipRepair);
            EquipInfoVO equipInfoVO = null;
            equipInfoVO = equipInfoService.queryById(equipRepair.getEquipInfoId());
            if (equipInfoVO == null) return new WebResult("failed", "请检查equipInfoId是否有值");
            if(flag) {
                equipInfoVO.setStatus(3);
                equipInfoService.updateStatus(equipInfoVO);
                return new WebResult("success", "新增成功");
            }
            return new WebResult("failed", "新增失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "设备维修修改", notes = "设备维修修改")
    @ApiImplicitParam(name = "equipRepair", value = "equipRepair", required = true, dataType = "equipRepair")
    @RequestMapping(value = "/repair/update", method = RequestMethod.POST)
    public WebResult<EquipRepair> update(EquipRepair equipRepair) {
        try {
            boolean flag = equipRepairService.update(equipRepair);
            EquipInfoVO equipInfoVO = null;
            equipInfoVO = equipInfoService.queryById(equipRepair.getEquipInfoId());
            if (equipInfoVO == null) return new WebResult("failed", "请检查equipInfoId是否有值");
            if(flag) {
                // 根据维修状态修改设备的状态
                equipInfoVO.setStatus(equipRepair.getStatus());
                equipInfoService.updateStatus(equipInfoVO);
                return new WebResult("success", "修改成功");
            }

            return new WebResult("failed", "修改失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }

    }
    @ApiOperation(value = "设备维修删除", notes = "设备维修删除")
    @ApiImplicitParam(name = "id", value = "根据id删除", required = true, dataType = "Integer")
    @RequestMapping(value = "/repair/del", method = RequestMethod.GET)
    public WebResult<EquipScrap> del(Integer id) {
        try {
            boolean flag = equipRepairService.del(id);
            if(flag)
                return new WebResult("success", "删除成功");
            return new WebResult("failed", "删除失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "查找设备维修", notes = "根据名称，类型，日期等查询")
    @ApiImplicitParam(name = "equipRepair", value = "设备维修对象", required = true, dataType = "equipRepair")
    @RequestMapping(value = "/repair/find", method = RequestMethod.GET)
    public WebResult<EquipRepair> find(EquipRepair equipRepair) {
        WebResult result = new WebResult<EquipRepair>();
        PageHelper.startPage(1, 100);
        try {
            List<EquipRepair> list = equipRepairService.find(equipRepair);
            PageInfo<EquipRepair> pageInfo = new PageInfo<EquipRepair>(list);
            result.setCode("success");
            result.setData(pageInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("error");
            result.setData(e.getClass().getName());
            return result;
        }
    }
}