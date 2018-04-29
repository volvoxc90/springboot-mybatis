package com.example.controller;

import com.example.domain.EquipVO;
import com.example.service.EquipService;
import com.example.utils.WebResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/equip/find")
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
            result.setCode("faile");
            result.setData("查询失败");
            return result;
        }
    }
}