package com.example.controller;

import com.example.domain.EquipVO;
import com.example.service.EquipService;
import com.example.utils.WebResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @create 2018-04-29 15:33
 **/
@RestController
public class EquipController {

    private static final Logger log = LoggerFactory.getLogger(EquipController.class);

    @Autowired
    private EquipService equipService;
    @ApiOperation(value = "查找设备", notes = "根据设备名称，类型，日期等查询")
    @ApiImplicitParam(name = "equipVO", value = "设备VO对象", required = true, dataType = "equipVO")
    @RequestMapping(value = "/equip/find", method = RequestMethod.GET)
    public WebResult<EquipVO> find(EquipVO equipVO) {
        WebResult result = new WebResult<EquipVO>();
        PageHelper.startPage(1, 12);
        try {
            List<EquipVO> list =  equipService.find(equipVO);
            PageInfo<EquipVO> pageInfo = new PageInfo<EquipVO>(list);
            result.setCode("success");
            result.setData(pageInfo);
            log.info( "查询结果：" + result);
            return result;
        } catch (Exception e) {
           log.info(e.getClass().getName());
            result.setCode("failed");
            result.setData("查询失败");
            return result;
        }
    }

    @ApiOperation(value = "添加设备", notes = "根据equipVO对象添加设备")
    @ApiImplicitParam(name = "equipVO", value = "设备VO对象", required = true, dataType = "equipVO")
    @RequestMapping(value = "/equip/save", method = RequestMethod.GET)
    public WebResult<EquipVO> save(@RequestBody EquipVO equipVO) {
        WebResult result = new WebResult<EquipVO>();
        try {
            boolean flag = equipService.save(equipVO);
            if(flag) {
                result.setCode("success");
                result.setData("添加成功");
                return result;
            }
            result.setCode("failed");
            result.setData("添加失败");
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            log.info(e.getClass().getName());
            result.setCode("error");
            result.setData(e.getClass().getName());
            return result;
        }
    }
    @ApiOperation(value = "修改设备", notes = "根据id修改")
    @ApiImplicitParam(name = "equipVO", value = "设备equipVO对象", required = true, dataType = "equipVO")
    @RequestMapping(value = "/equip/update", method = RequestMethod.GET)
    public WebResult<EquipVO> update(EquipVO equipVO) {
        WebResult result = new WebResult<EquipVO>();
        try {
            Boolean flag = equipService.update(equipVO);
            if (flag) {
                result.setCode("success");
                result.setData("修改成功");
                return result;
            }
            result.setCode("failed");
            result.setData("修改失败");
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            log.info(e.getClass().getName());
            result.setCode("error");
            result.setData(e.getClass().getName());
            return result;
        }
    }

    @ApiOperation(value = "删除设备", notes = "根据id删除设备")
    @ApiImplicitParam(name = "id", value = "设备id", required = true, dataType = "Integer")
    @RequestMapping(value = "/equip/delById", method = RequestMethod.GET)
    public WebResult<EquipVO> delById(Integer id) {
        WebResult result = new WebResult<EquipVO>();
        try {
            if (id == null) {
                result.setCode("failed");
                result.setData("参数有误");
                return result;
            }
            boolean flag = equipService.delById(id);
            if (flag) {
                result.setCode("success");
                result.setData("删除成功");
                return result;
            }
            result.setCode("failed");
            result.setData("删除失败");
            return result;
        }catch (Exception e) {
            log.info(e.getClass().getName());
            result.setCode("error");
            result.setData(e.getClass().getName());
            return result;
        }
    }
}