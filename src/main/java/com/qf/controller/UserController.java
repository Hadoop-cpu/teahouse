package com.qf.controller;


import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Author: 马陈浩
 * @Date: 2020/7/18
 * @Time: 11:23
 */
@Api(tags = "茶小屋 用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public R updateUser(User user) {
        return userService.updateUser(user);
    }
    /**
     * 根据id查询用户信息
     */
    @PostMapping("/selectUserById/{id}")
    public R selectUserById(@PathVariable Integer id) {
        return userService.selectUserById(id);
    }
}
