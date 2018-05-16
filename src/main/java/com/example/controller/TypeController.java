package com.example.controller;

import com.example.domain.EquipScrap;
import com.example.domain.Type;
import com.example.service.TypeService;
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
public class TypeController {
    
    @Autowired
    private TypeService typeService;
    
    @ApiOperation(value = "设备类型新增", notes = "设备类型新增")
    @ApiImplicitParam(name = "typeVO", value = "设备类型对象typeVO", required = true, dataType = "typeVO")
    @RequestMapping(value = "/type/save", method = RequestMethod.POST)
    public WebResult<Type> save(Type typeVO) {
        try {
            boolean flag = typeService.save(typeVO);
            if(flag)
                return new WebResult("success", "新增成功");
            return new WebResult("failed", "新增失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "设备类型修改", notes = "设备类型修改")
    @ApiImplicitParam(name = "typeVO", value = "typeVO", required = true, dataType = "typeVO")
    @RequestMapping(value = "/type/update", method = RequestMethod.POST)
    public WebResult<Type> update(Type typeVO) {
        try {
            boolean flag = typeService.update(typeVO);
            if(flag)
                return new WebResult("success", "修改成功");
            return new WebResult("failed", "修改失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }

    }
    @ApiOperation(value = "设备类型删除", notes = "设备类型删除")
    @ApiImplicitParam(name = "id", value = "根据id删除", required = true, dataType = "Integer")
    @RequestMapping(value = "/type/del", method = RequestMethod.GET)
    public WebResult<Type> del(Integer id) {
        try {
            boolean flag = typeService.del(id);
            if(flag)
                return new WebResult("success", "删除成功");
            return new WebResult("failed", "删除失败");

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "查找设备类型", notes = "设备类型查询")
    @ApiImplicitParam(name = "typeVO", value = "设备类型对象", required = true, dataType = "typeVO")
    @RequestMapping(value = "/type/find", method = RequestMethod.GET)
    public WebResult<Type> find(Type typeVO) {
        WebResult result = new WebResult<Type>();
        PageHelper.startPage(1, 12);
        try {
            List<Type> list = typeService.find(typeVO);
            PageInfo<Type> pageInfo = new PageInfo<Type>(list);
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
    @ApiOperation(value = "查找所有设备类型", notes = "设备类型查询")
    @ApiImplicitParam(name = "typeVO", value = "设备类型对象", required = true, dataType = "typeVO")
    @RequestMapping(value = "/type/queryAll", method = RequestMethod.GET)
    public WebResult<Type> queryAll() {
        WebResult result = new WebResult<Type>();
        try {
            List<Type> list = typeService.queryAll();
            result.setCode("success");
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("error");
            result.setData(e.getClass().getName());
            return result;
        }
    }
    @ApiOperation(value = "查找设备类型", notes = "设备类型查询")
    @ApiImplicitParam(name = "id", value = "设备类型对象id", required = true, dataType = "Integer")
    @RequestMapping(value = "/type/queryById", method = RequestMethod.GET)
    public WebResult<Type> queryById(Integer id) {
        WebResult result = new WebResult<Type>();
        try {
            List<Type> list = typeService.queryAll();
            result.setCode("success");
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("error");
            result.setData(e.getClass().getName());
            return result;
        }
    }

}