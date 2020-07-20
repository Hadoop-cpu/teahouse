package com.qf.service;

import com.qf.dto.UserDto;
import com.qf.dto.UserLoginDto;
import com.qf.vo.R;

/**
 * @ClassName: UserService
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 11:23
 */

public interface UserService {
    R checkUser_phone(String user_phone);
    R login(UserLoginDto loginDto);
    R register(UserDto dto);
    R findPass(UserLoginDto loginDto);
    R changePass(String token, String pass);
    R checkToken(String token);
    R loginout(String token);
}
