package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.WebResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhugp
 * @create 2018-03-20 10:08
 **/
@RestController
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "user/getUserByName", method = RequestMethod.GET)
    public WebResult getUserByName(@RequestParam("username") String username) {
        if (StringUtils.isBlank(username))
            return new WebResult("FAILD", "请输入参数");
        try {
            List list = userService.getUserByName(username);
            return new WebResult("SUCCESS", list);
        } catch (Exception e) {
            return new WebResult("ERROR", e.getClass().getName());
        }
    }

    @RequestMapping("user/getUsers")
    public WebResult getUsers() {
        List list = userService.getUsers();
        return new WebResult("SUCCESS", list);
    }
}
