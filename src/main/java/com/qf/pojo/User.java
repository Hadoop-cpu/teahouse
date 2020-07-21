package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: User
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 10:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer user_id;    //用户id
    private String user_phone;  //用户手机！！！注意这里是字符串类型
    private String user_pwd;    //密码
    private String user_email;  //用户邮箱
    private String user_name;   //用户昵称
    private char user_sex;      //用户性别
    private String user_TrueName;  //真实姓名

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public User() {
    }

    public User(String user_phone, String user_pwd, String user_email, String user_name) {
        this.user_phone = user_phone;
        this.user_pwd = user_pwd;
        this.user_email = user_email;
        this.user_name = user_name;
    }

    public User(Integer user_id, String user_phone, String user_pwd, String user_email, String user_name) {
        this.user_id = user_id;
        this.user_phone = user_phone;
        this.user_pwd = user_pwd;
        this.user_email = user_email;
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_phone='" + user_phone + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
