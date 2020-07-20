package com.qf.service.impl;


import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.UserDao;
import com.qf.dto.UserDto;

import com.qf.dto.UserLoginDto;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.util.EncryptUtil;
import com.qf.util.JedisCore;
import com.qf.util.TokenUtil;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: UserServiceImpl
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 11:29
 */


@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;
    @Autowired
    private JedisCore jedisCore;
    @Value("${voter.aes.passkey}")   ///有问题需要解决
    public String key;


    @Override
    public R checkUser_phone(String user_phone) {
        User user = dao.selectByPhone(user_phone);
        if (user != null) {
            return R.error("手机号已经存在");
        } else {
            return R.ok();
        }
    }

    //唯一登录 一个账号只能在线一个
    @Override
    public R login(UserLoginDto loginDto) {
        if (jedisCore.checkKey(RedisKeyConfig.PHONE_FOR + loginDto.getUser_phone())) {
            return R.error("亲，账号被冻结请" + jedisCore.ttl(RedisKeyConfig.PHONE_FOR + loginDto.getUser_phone()) + "秒之后重新登录！");
        } else if (jedisCore.checkKey(RedisKeyConfig.PHONE_TOKEN + loginDto.getUser_phone())) {
            return R.error("亲您已经登录了");
        } else {
            User user = dao.selectByPhone(loginDto.getUser_phone());
            boolean iserror = true;
            if (user != null) {
                //比较密码
                if (user.getUser_pwd().equals(EncryptUtil.aesenc(key, loginDto.getUser_pwd()))) {
                    //成功 生成令牌 有效期 存储到Redis
                    String token = TokenUtil.createToken(user.getUser_id());

                    //存储到Redis
                    jedisCore.set(RedisKeyConfig.PHONE_TOKEN + loginDto.getUser_phone(), token, RedisKeyConfig.TOKEN_TIME);
                    jedisCore.set(RedisKeyConfig.TOKEN_USER + token, JSON.toJSONString(user), RedisKeyConfig.TOKEN_TIME);
                    System.out.println(token);
                    iserror = false;
                    return R.ok(token);

                }
            }
            if (iserror) {
                //本次登录失败
                //校验错误的次数 10分钟内的
                if (jedisCore.keys(RedisKeyConfig.PHONE_ERROR + loginDto.getUser_phone()) == 2) {
                    //进行账号的冻结 30分钟
                    jedisCore.set(RedisKeyConfig.PHONE_FOR + loginDto.getUser_phone(), System.currentTimeMillis() + "", RedisKeyConfig.TOKENFOR_TIME);
                }
                //记录本次错误
                jedisCore.set(RedisKeyConfig.PHONE_ERROR + loginDto.getUser_phone() + ":" + System.currentTimeMillis(), "", RedisKeyConfig.PHONERROR_TIME);
            }
            //错误次数限定 10分钟内 连续错误3次 冻结账号30分钟
            return R.error("账号或密码错误");
        }
    }

    //注册
    @Transactional//开启事务 保证操作的一致性
    @Override
    public R register(UserDto dto) {
        //校验手机号
        if (checkUser_phone(dto.getUser_phone()).getCode() == 200) {
            //密文
            dto.setUser_pwd(EncryptUtil.aesenc(key, dto.getUser_pwd()));
            //新增
            User user = new User();
            user.setUser_name(dto.getUser_name());
            user.setUser_pwd(dto.getUser_pwd());
            user.setUser_email(dto.getUser_email());
            user.setUser_phone(dto.getUser_phone());
            dao.insert(user);
            //给前台返回可以使用的数据
            return R.ok(user);
        } else {
            return R.error("尊敬的用户您好，此手机号已被注册");
        }
    }

    //找回密码
    @Override
    public R findPass(UserLoginDto loginDto) {
        if (dao.findPsw(loginDto.getUser_phone(), EncryptUtil.aesenc(key, loginDto.getUser_pwd())) > 0) {
            return R.ok();
        } else {
            return R.error("手机号不存在");
        }
    }

    //修改密码
    @Override
    public R changePass(String token, String pass) {
        if (jedisCore.checkKey(RedisKeyConfig.TOKEN_USER + token)) {
            User user = JSON.parseObject(jedisCore.get(RedisKeyConfig.PHONE_TOKEN + token), User.class);
            if (dao.changePsw(user.getUser_id(), EncryptUtil.aesenc(key, pass)) > 0) {
                //删除令牌
                jedisCore.del(RedisKeyConfig.TOKEN_USER + token);
                jedisCore.del(RedisKeyConfig.PHONE_TOKEN + user.getUser_pwd());
                return R.ok("密0码修改成功，请重新登录");
            }
        }
        return R.error("密码修改失败");
    }


    @Override
    public R checkToken(String token) {
        if (token != null && token.length() > 0) {
            if (jedisCore.checkKey(RedisKeyConfig.TOKEN_USER + token)) {
                return R.ok();
            }
        }
        return R.error("令牌无效");
    }

    //退出
    @Override
    public R loginout(String token) {
        if (token != null && token.length() > 0) {
            User user = JSON.parseObject(jedisCore.get(RedisKeyConfig.TOKEN_USER + token), User.class);

            jedisCore.del(RedisKeyConfig.PHONE_TOKEN + user.getUser_phone());
            jedisCore.del(RedisKeyConfig.TOKEN_USER + token);
            return R.ok();
        }
        return R.error("请传递令牌");
    }
}
