package com.qf.pojo;

import lombok.Data;

/**
 * @ClassName: User
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 10:32
 */
@Data
public class User {
    private Integer user_id;    //用户id
    private String user_phone;  //用户手机！！！注意这里是字符串类型
    private String user_pwd;    //密码
    private String user_email;  //用户邮箱
    private String user_name;   //用户名

}
