package com.example.controller;

import com.example.utils.FileUtil;
import com.example.utils.WebResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @create 2018-04-29 10:40
 **/
@RestController
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    //跳转到上传文件的页面
    @RequestMapping(value="goUploadImg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "/uploadimg.html";
    }

    @RequestMapping(value = "/util/uploadImg", method = RequestMethod.POST)
    public WebResult uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//        String contextType = file.getContentType();
        String fileName = file.getOriginalFilename();
        try {
            String filePath = request.getSession().getServletContext().getRealPath("/image");
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            return new WebResult("success", fileName);
        } catch (Exception e) {
            log.info(e.getClass().getName());
            return new WebResult("faile", fileName);
        }
    }
}