package com.qf.service;


import com.qf.pojo.User;
import com.qf.vo.R;

import java.util.List;

import com.qf.dto.UserDto;
import com.qf.dto.UserLoginDto;
import com.qf.vo.R;


/**
 * @ClassName: UserService
 * @Author: 马陈浩
 * @Date: 2020/7/18
 * @Time: 11:23
 */

public interface UserService {
    //修改user信息
    R updateUser(User user);
    //根据id查询用户信息
    R selectUserById(Integer user_id);


    R checkUser_phone(String user_phone);
    R login(UserLoginDto loginDto);
    R register(UserDto dto);
    R findPass(UserLoginDto loginDto);
    R changePass(String token, String pass);
    R checkToken(String token);
    R loginout(String token);

}
