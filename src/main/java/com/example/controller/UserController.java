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

import java.util.Date;
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

    /**
     * 不带分页和参数
     * @return
     */
    @RequestMapping("user/getAll2")
    public PageInfo getAll2() {
        List list = userService.getAll2();
        return new PageInfo(list);
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

    @RequestMapping(value = "user/updateByUser")
    public WebResult updateByUser(User user) {
        boolean flag = userService.updateByUser(user);
        if(flag){
            return new WebResult("success", "修改成功");
        }
        return new WebResult("faile", "修改失败");
    }

    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    public WebResult add(User user){
        //user.setCtm(new Date().toString());
        boolean flag = userService.add(user);
        if (flag)
            return new WebResult("success", "新增成功");
        return new WebResult("faile", "新增失败");
    }

    @RequestMapping(value = "user/deleteById")
    public WebResult deleteById(@RequestParam Integer id) {
        int flag = userService.deleteById(id);
        if (flag == 1) return new WebResult("success", "删除成功");
        return new WebResult("faile", "删除失败");
    }

    @RequestMapping(value = "user/findByUserNameLike")
    public PageInfo<User> findByUserNameLike(User user) {
        List<User> list = userService.findByUserNameLike(user);
        return new PageInfo<>(list);
    }
}
