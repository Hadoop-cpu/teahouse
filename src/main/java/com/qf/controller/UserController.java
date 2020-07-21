package com.qf.controller;



import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qf.constant.SystemConstant;
import com.qf.dto.UserDto;
import com.qf.dto.UserLoginDto;
import com.qf.service.UserService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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


    @Autowired
    private UserService service;

    @ApiOperation(value = "校验手机号是否存在", notes = "校验手机号是否存在")
    @GetMapping("api/user/checkUser_phone/{user_phone}")
    public R check(@PathVariable String user_phone){
        return service.checkUser_phone(user_phone);
    }

    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping("api/user/register")
    public R add(@RequestBody UserDto dto){
        return service.register(dto);
    }

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("api/user/login")
    public R login(@RequestBody UserLoginDto dto){
        return service.login(dto);
    }

    @ApiOperation(value = "找回密码", notes = "找回密码")
    @PostMapping("api/user/findpass")
    public R find(@RequestBody UserLoginDto loginDto){
        return service.findPass(loginDto);
    }

    @ApiOperation(value = "更改密码", notes = "更改密码")
    @PostMapping("api/user/changepass/{pass}")
    public R changePage(HttpServletRequest request,@PathVariable String pass){
        String token = request.getHeader(SystemConstant.TOKEN_HEADER);
        System.err.println("----->" + token);
        return service.changePass(token, pass);
    }

    @ApiOperation(value = "退出", notes = "退出")
    @GetMapping ("api/user/loginout")
    public R loginout(HttpServletRequest request){
        return service.loginout(request.getHeader(SystemConstant.TOKEN_HEADER));
    }

    @ApiOperation(value = "检查令牌", notes = "检查令牌")
    @GetMapping("api/user/checktoken")
    public R chenkToken(HttpServletRequest request){
        return service.checkToken(request.getHeader(SystemConstant.TOKEN_HEADER));

    }
}
