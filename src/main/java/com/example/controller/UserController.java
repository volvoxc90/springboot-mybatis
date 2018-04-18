package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.WebResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 带分页，参数为对象的查询
     * 前端请求地址：../user/getAll?username=zhangsan&age=23
     * 参数可以是多个 user对象的属性拼接
     *
     * 在xxxMapper.xml中的写法
     *  <select id="getAll"   resultMap="user">
            SELECT <include refid="Base_Column_List"/>
            FROM tb_user
         <if test="user != null">
            WHERE age = #{user.age}
            AND  username = #{user.username}
        </if>
     </select>
     *
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user/getAll")
    public PageInfo<User> getAll(User user) {
        PageHelper.startPage(1, 12);
        List<User> userList = userService.getAll(user);
        PageInfo pageInfo = new PageInfo(userList);
        return pageInfo;
    }

    @RequestMapping("user/getUsers")
    public WebResult getUsers() {
        List list = userService.getUsers();
        return new WebResult("SUCCESS", list);
    }

    /**
     * 带分页
     * @param age
     * @return
     */
    @RequestMapping(value = "user/getUserByAge")
    public PageInfo<User> getUserByAge(@RequestParam Integer age) {
        List<User> userList = userService.getUserByAge(age);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
     * 不带分页
     * @param age
     * @return
     */
    @RequestMapping(value = "user/getUserByAge2")
    public WebResult getUserByAge2(@RequestParam Integer age) {
        List<User> userList = userService.getUserByAge(age);
        return new WebResult("SUCCESS", userList);
    }
}
