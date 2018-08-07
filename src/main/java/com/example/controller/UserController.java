package com.example.controller;

import com.example.domain.StatusVO;
import com.example.domain.User;
import com.example.service.EquipBorrowReturnService;
import com.example.service.EquipInfoService;
import com.example.service.EquipRepairService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EquipInfoService equipService;

    @Autowired
    private EquipBorrowReturnService equipBorrowReturnService;

    @Autowired
    private EquipRepairService equipRepairService;


    /**
     * 带分页，参数为对象的查询
     * 前端请求地址：../user/getAll?username=zhangsan&age=23
     * 参数可以是多个 user对象的属性拼接
     * <p>
     * 在xxxMapper.xml中的写法
     * <select id="getAll"   resultMap="user">
     * SELECT <include refid="Base_Column_List"/>
     * FROM tb_user
     * <if test="user != null">
     * WHERE age = #{user.age}
     * AND  username = #{user.username}
     * </if>
     * </select>
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user/queryAll", method = RequestMethod.GET)
    public WebResult<User> queryAll(User user) {
        WebResult result = new WebResult();
        result.setCode("success");
        List<User> userList = userService.queryAll();
        result.setData(userList);
        return result;
    }

    @RequestMapping(value = "user/getUserByName", method = RequestMethod.GET)
    public WebResult<User> getUserByName(User user) {
        WebResult result = new WebResult();
        result.setCode("success");
        List<User> userList = userService.getUserByName(user);
        result.setData(userList);
        return result;
    }

    /**
     * 登录
     *
     * @param
     * @param
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "根据用户名和密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @PostMapping(value = "user/login")
    public WebResult<User> login(User user, HttpServletRequest request) {
        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())) {
            return new WebResult("error", "请输入用户名和密码");
        }
        User user1 = userService.getUser(user.getUserName(), user.getPassword());
        if (user1 == null) {
            return new WebResult("failed", "登录失败，用户名或者密码错误");
        }

//        User user2 = userService.getUserByName(user.getUserName());
//        request.getSession().setAttribute("user", user2);

        Map<String, Object> map = new HashMap<>();
        List<StatusVO> equipInfoCount = equipService.queryAllStatus();
        Integer equipRepairCount = equipRepairService.queryCount(null);
        Integer equipBorrowCount = equipBorrowReturnService.queryCount(null);

        map.put("equipInfoCount", equipInfoCount);
        map.put("equipRepairCount", equipRepairCount);
        map.put("equipBorrowCount", equipBorrowCount);

        return new WebResult("success", map);
    }

    @GetMapping("/user/isOperator")
    public WebResult isOperator(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user.getStatus() == 1) {
            return new WebResult("success", 1);
        } else {
            return new WebResult("common", 0);
        }
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "根据user对象新增用户")
    @ApiImplicitParam(name = "user", value = "user对象", required = true, dataType = "user")
    @RequestMapping(value = "user/save", method = RequestMethod.POST)
    public WebResult save(User user) {
        try {
            if (user.getId() == null || user.getId() == 0) {
                boolean flag = userService.add(user);
                if (flag)
                    return new WebResult("success", "新增成功");
                return new WebResult("failed", "新增失败");
            } else {
                boolean flag = userService.updateByUser(user);
                if (flag) {
                    return new WebResult("success", "修改成功");
                }
                return new WebResult("failed", "修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }

    }

    @ApiOperation(value = "修改用户", notes = "根据user对象修改")
    @ApiImplicitParam(name = "user", value = "user对象", required = true, dataType = "user")
    @RequestMapping(value = "user/updateByUser")
    public WebResult updateByUser(User user) {
        boolean flag = userService.updateByUser(user);
        if (flag) {
            return new WebResult("success", "修改成功");
        }
        return new WebResult("failed", "修改失败");
    }


    /**
     * 管理员删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据id删除")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer")
    @RequestMapping(value = "user/del", method = RequestMethod.POST)
    public WebResult del(@RequestParam Integer id, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            if (user.getStatus() != 1) {
                return new WebResult("failed", "该用户不是管理员，无权删除");
            }
        }
        boolean flag = userService.deleteById(id);
        if (flag) return new WebResult("success", "删除成功");
        return new WebResult("failed", "删除失败");
    }

    @ApiOperation(value = "修改密码", notes = "根据id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/user/updatePwd", method = RequestMethod.POST)
    public WebResult updatePwd(String oldPassword, String newPassword, HttpServletRequest request) {
        if (StringUtils.isBlank(oldPassword)) {
            return new WebResult("failed", "请输入参数");
        }
        if (StringUtils.isBlank(newPassword)) {
            return new WebResult("failed", "请输入参数");
        }
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (oldPassword.equalsIgnoreCase(user.getPassword())) {
                boolean flag = userService.updatePwd(newPassword, user.getId());
                if (flag)
                    return new WebResult("success", "修改密码成功");
                return new WebResult("failed", "修改密码失败");
            } else {
                return new WebResult("error", "输入旧密码不正确");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new WebResult("error", e.getClass().getName());
        }
    }

    @RequestMapping(value = "user/selectCount")
    public WebResult selectCount(User user) {
        Map<String, String >map = userService.selectCount(user);
        return new WebResult("success", map);
    }



}
