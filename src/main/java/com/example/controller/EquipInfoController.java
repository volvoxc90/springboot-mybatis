package com.example.controller;

import com.example.domain.EquipInfoVO;
import com.example.domain.StatusVO;
import com.example.service.EquipBorrowReturnService;
import com.example.service.EquipInfoService;
import com.example.service.EquipRepairService;
import com.example.utils.WebResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.text.SimpleDateFormat;


@RestController
public class EquipInfoController {

    private static final Logger log = LoggerFactory.getLogger(EquipInfoController.class);

    @Autowired
    private EquipInfoService equipService;

    @Autowired
    private EquipBorrowReturnService equipBorrowReturnService;

    @Autowired
    private EquipRepairService equipRepairService;

    // 图片上传路径
    @Value("${web.upload-path}")
    private String imgFilePath;

    @ApiOperation(value = "查找设备", notes = "根据设备名称，类型，日期等查询")
    @ApiImplicitParam(name = "equipInfoVO", value = "设备VO对象", required = true, dataType = "equipInfoVO")
    @RequestMapping(value = "/equip/find", method = RequestMethod.GET)
    public WebResult<EquipInfoVO> find(EquipInfoVO equipInfoVO) {
        WebResult result = new WebResult<EquipInfoVO>();
        PageHelper.startPage(1, 1000);
        try {
            List<EquipInfoVO> list = equipService.find(equipInfoVO);
            PageInfo<EquipInfoVO> pageInfo = new PageInfo<EquipInfoVO>(list);
            result.setCode("success");
            result.setData(pageInfo);
            log.info("查询结果：" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getClass().getName());
            result.setCode("error");
            result.setData(e.getClass().getName());
            return result;
        }
    }

    @ApiOperation(value = "根据id查找设备", notes = "根据id查找设")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer")
    @RequestMapping(value = "/equip/queryById", method = RequestMethod.GET)
    public WebResult<EquipInfoVO> queryById(Integer id) {
        try {
            EquipInfoVO equipInfoVO = equipService.queryById(id);
            return new WebResult("success", equipInfoVO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getClass().getName());
            return new WebResult("error", e.getClass().getName());
        }
    }

    @ApiOperation(value = "查找所有设备", notes = "查找所有设备名称")
    @RequestMapping(value = "/equip/queryAll", method = RequestMethod.GET)
    public List<EquipInfoVO> queryAll() {
        List<EquipInfoVO> list = new ArrayList<>();
        try {
            list = equipService.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @ApiOperation(value = "添加设备", notes = "根据equipVO对象添加设备")
    @ApiImplicitParam(name = "equipInfoVO", value = "设备VO对象", required = true, dataType = "equipInfoVO")
    @RequestMapping(value = "/equip/save", method = RequestMethod.POST)
    public WebResult<EquipInfoVO> save(EquipInfoVO equipInfoVO) {
        try {
            if(StringUtils.isNotBlank(equipInfoVO.getFileData())) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");
                String imgName = sdf.format(new java.util.Date());
                String fileData = this.setImgPath(equipInfoVO.getFileData()) + imgName +  ".jpg";
                if(StringUtils.isBlank(fileData)) return new WebResult("failed", "上传文件路径不对");
                equipInfoVO.setFileData(fileData);
            }

            boolean flag = equipService.save(equipInfoVO);
            if (flag) {
                return new WebResult("success", "添加成功");
            }
            return new WebResult("failed", "添加失败");
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getClass().getName());
            return new WebResult("error", e.getClass().getName());
        }
    }

    /**
     * 设置图片保存路径
     * @param fileData
     * @return
     */
    private String setImgPath(String fileData) {
        if (org.apache.commons.lang3.StringUtils.isBlank(fileData))
            return null;
        String imgStrs[] = fileData.split(",");
        String imgStr = imgStrs[1];
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HHmmss");
            String imgName = sdf.format(new java.util.Date());
            // 保存到本地硬盘
            OutputStream out = new FileOutputStream(imgFilePath + "/" + imgName + ".jpg");
            out.write(b);
            out.flush();
            out.close();
            return imgFilePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @ApiOperation(value = "修改设备", notes = "根据id修改")
    @ApiImplicitParam(name = "equipInfoVO", value = "设备equipVO对象", required = true, dataType = "equipInfoVO")
    @RequestMapping(value = "/equip/update", method = RequestMethod.POST)
    public WebResult<EquipInfoVO> update(EquipInfoVO equipInfoVO) {
        try {
            Boolean flag = equipService.update(equipInfoVO);
            if (flag) {
                return new WebResult("success", "修改成功");
            }
            return new WebResult("failed", "修改失败");
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getClass().getName());
            return new WebResult("error", e.getClass().getName());
        }
    }


    @ApiOperation(value = "删除设备", notes = "根据id删除设备")
    @ApiImplicitParam(name = "id", value = "设备id", required = true, dataType = "Integer")
    @RequestMapping(value = "/equip/del")
    public WebResult<EquipInfoVO> del(Integer id) {
        try {

            if (id == null) {
                return new WebResult("failed", "参数有误");
            }
            EquipInfoVO equipInfoVO = equipService.queryById(id);
            if (equipInfoVO != null)
                if (equipInfoVO.getStatus() != 1)
                    return new WebResult("failed", "请选择设备状态为闲置的记录");
            boolean flag = equipService.delById(id);
            if (flag) {
                return new WebResult("success", "删除成功");
            }
            return new WebResult("failed", "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getClass().getName());
            return new WebResult("error", e.getClass().getName());
        }
    }

    /**
     * 查询所有状态
     * @return
     */
    @GetMapping("/equip/queryAllStatus")
    public WebResult queryAllStatus() {

//        List<Object> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        List<StatusVO> equipInfoCount = equipService.queryAllStatus();

        Integer equipRepairCount = equipRepairService.queryCount(null);
        Integer equipBorrowCount = equipBorrowReturnService.queryCount(null);


        map.put("equipInfoCount", equipInfoCount); //外围饼图数据
        map.put("equipRepairCount", equipRepairCount); //内围饼图数据
        map.put("equipBorrowCount", equipBorrowCount); //内围饼图数据

        return new WebResult("success", map);
    }

    @RequestMapping(value = "/equip/queryEquipInfoByUser", method = RequestMethod.GET)
    public WebResult queryEquipInfoByUser(EquipInfoVO equipInfoVO) {
        List<EquipInfoVO> list = equipService.queryEquipInfoByUser(equipInfoVO);
        return new WebResult("success", list);
    }



    public java.lang.String getImgFilePath() {
        return imgFilePath;
    }

    public void setImgFilePath(java.lang.String imgFilePath) {
        this.imgFilePath = imgFilePath;
    }
}