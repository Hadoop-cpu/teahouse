package com.qf.dto;

import lombok.Data;
/**
 * @ClassName: UserDto
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 11:23
 */
@Data
public class UserDto {
    private String user_phone;
    private String user_pwd;
    private String user_name;
    private String user_email;
}
