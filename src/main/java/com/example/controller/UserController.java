package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.WebResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    public List<User> getUserByName(@RequestParam("username") String username) {
        try {
            List list = userService.getUserByName(username);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
    public WebResult<User> getAll(User user) {
        WebResult result = new WebResult();
        result.setCode("success");
        PageHelper.startPage(1, 12);
        List<User> userList = userService.getAll(user);
        result.setData(new PageInfo<User>(userList));
        return result;
    }

    /**
     * 不带分页和参数
     * @return
     */
    @RequestMapping("user/getAll2")
    public WebResult<User> getAll2() {
        List list = userService.getAll2();
        return new WebResult("success", new PageInfo<User>(list));
    }

    /**
     * 带分页
     * @param age
     * @return
     */
    @RequestMapping(value = "user/getUserByAge")
    public WebResult<User> getUserByAge(@RequestParam Integer age) {
        WebResult result = new WebResult();
        List<User> userList = userService.getUserByAge(age);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        result.setCode("success");
        result.setData(pageInfo);
        return result;
    }

    /**
     * 不带分页
     * @param age
     * @return
     */
    @RequestMapping(value = "user/getUserByAge2")
    public WebResult getUserByAge2(@RequestParam Integer age) {
        WebResult result = new WebResult();
        List<User> userList = userService.getUserByAge(age);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        result.setCode("success");
        result.setData(pageInfo);
        return result;
    }

    @RequestMapping(value = "user/updateByUser")
    public WebResult updateByUser(User user) {
        boolean flag = userService.updateByUser(user);
        if(flag){
            return new WebResult("success", "修改成功");
        }
        return new WebResult("faile", "修改失败");
    }


    /**
     * 管理员删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/deleteById")
    public WebResult deleteById(@RequestParam Integer id) {
        int flag = userService.deleteById(id);
        if (flag == 1) return new WebResult("success", "删除成功");
        return new WebResult("faile", "删除失败");
    }


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名称", required = true , dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping(value = "user/login")
    public WebResult login(@RequestParam String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return new WebResult("failed", "请输入用户名或者密码");
        }
        List list = this.getUserByName(username);
        if (list.size() > 0) {
            return new WebResult("success", "登录成功");
        }
        return null;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    public WebResult add( User user){
        try {
            if (StringUtils.isBlank(user.getUserName())) {
                return new WebResult("failed", "新增失败");
            }
            boolean flag = userService.add(user);
            if (flag)
                return new WebResult("success", "新增成功");
            return new WebResult("failed", "新增失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }

    }
}
