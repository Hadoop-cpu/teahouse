package com.qf.dao;

import com.qf.pojo.User;

import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserDao
 * @Author: 马陈浩
 * @Date: 2020/7/18
 * @Time: 11:22
 */
@Repository
public interface UserDao {

    //修改user信息
    int updateUser(User user);
    //根据id查询用户信息
    User selectUserById(int user_id);


    //注册
    @Insert("insert into user(user_phone,user_pwd,user_email,user_name) values(#{user_phone},#{user_pwd},#{user_email},#{user_name})")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")
    int insert(User user);

    //检验手机号
    @Select("select user_id,user_phone,user_pwd,user_email,user_name from user where user_phone=#{user_phone}")
    com.qf.pojo.User selectByPhone(String user_phone);

    //修改密码
    @Update("update user set user_psw=#{user_psw} where user_id=#{user_id}")
    int changePsw(@Param("user_id") int user_id,@Param("user_psw") String user_psw);

    //找回密码
    @Update("update user set user_psw=#{user_psw} where user_phone=#{user_phone}")
    int findPsw(@Param("user_phone") String user_phone, @Param("user_psw") String user_psw);

}

