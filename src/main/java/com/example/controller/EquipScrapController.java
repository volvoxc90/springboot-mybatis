package com.example.controller;

import com.example.domain.EquipInfoVO;
import com.example.domain.EquipScrap;
import com.example.service.EquipScrapService;
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
public class EquipScrapController {

    @Autowired
    private EquipScrapService equipScrapService;

    @Autowired
    private EquipInfoService equipInfoService;

    @ApiOperation(value = "报废新增", notes = "报废新增")
    @ApiImplicitParam(name = "equipScrap", value = "根据equipScrap新增", required = true, dataType = "equipScrap")
    @RequestMapping(value = "/scrap/save", method = RequestMethod.POST)
    public WebResult<EquipScrap> save(EquipScrap equipScrap) {
        try {
            boolean flag = equipScrapService.save(equipScrap);
            EquipInfoVO equipInfoVO = null;
            if(flag) {
                equipInfoVO = equipInfoService.queryById(equipScrap.getEquipInfoId());
            }
            if (equipInfoVO != null){
                equipInfoVO.setStatus(2);
                equipInfoService.updateStatus(equipInfoVO);
                return new WebResult("success", "新增成功");
            }
            return new WebResult("failed", "新增失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "报废修改", notes = "报废修改")
    @ApiImplicitParam(name = "equipScrap", value = "根据equipScrap修改", required = true, dataType = "equipScrap")
    @RequestMapping(value = "/scrap/update", method = RequestMethod.POST)
    public WebResult<EquipScrap> update(EquipScrap equipScrap) {
        try {
            boolean flag = equipScrapService.update(equipScrap);
            if(flag)
                return new WebResult("success", "修改成功");
            return new WebResult("failed", "修改失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }

    }
    @ApiOperation(value = "报废删除", notes = "报废删除")
    @ApiImplicitParam(name = "id", value = "根据id删除", required = true, dataType = "equipScrap")
    @RequestMapping(value = "/scrap/del", method = RequestMethod.GET)
    public WebResult<EquipScrap> del(Integer id) {
        try {
            boolean flag = equipScrapService.del(id);
            if(flag)
                return new WebResult("success", "删除成功");
            return new WebResult("failed", "删除失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "查找报废", notes = "根据报废名称，类型，日期等查询")
    @ApiImplicitParam(name = "equipScrap", value = "报废对象", required = true, dataType = "equipScrap")
    @RequestMapping(value = "/scrap/find", method = RequestMethod.GET)
    public WebResult<EquipScrap> find(EquipScrap equipScrap) {
        WebResult result = new WebResult<EquipScrap>();
        PageHelper.startPage(1, 12);
        try {
            List<EquipScrap> list =  equipScrapService.find(equipScrap);
            PageInfo<EquipScrap> pageInfo = new PageInfo<EquipScrap>(list);
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