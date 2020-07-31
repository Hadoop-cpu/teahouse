package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.RecipientsDao;
import com.qf.pojo.Recipients;
import com.qf.pojo.User;
import com.qf.service.RecipientsService;
import com.qf.util.JedisCore;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Service
public class RecipientsServiceImpl implements RecipientsService {
    @Autowired
    private RecipientsDao recipientsDao;
    @Autowired
    private JedisCore jedisCore;

    @Override
    public R updateRecipients(Recipients recipients) {
        int i = recipientsDao.updateRecipients(recipients);
        if (i == 1) {
            return R.ok();
        } else {
            return R.error("修改失败，请重新修改");
        }
    }

    @Override
    public R deleteRecipientsByRecipId(Integer recipients_id) {
        int i = recipientsDao.deleteRecipientsByRecipId(recipients_id);
        if (i == 1) {
            return R.ok();
        } else {
            return R.error("删除失败，请重新删除");
        }
    }

    @Override
    public R selectRecipientsByUserId(HttpServletRequest request) {
        String token = request.getHeader("token");
        System.out.println(token);
        if (token==null || token==""){
            return R.error("登录失效");
        } else {
            User user = JSON.parseObject(jedisCore.get(RedisKeyConfig.TOKEN_USER + token), User.class);
            Integer user_id = user.getUser_id();
            List<Recipients> recipients = recipientsDao.selectRecipientsByUserId(user_id);
            HashMap<String, Object> map = new HashMap<>();
            map.put("recipients" , recipients);
            map.put("user",user);
            if (map != null) {
                return R.ok(map);
            }else  {
                return  R.error("查询失败");
            }

        }




    }

    @Override
    public R selectRecipientsByOne(Integer recipients_id) {
        Recipients recipients = recipientsDao.selectRecipientsByOne(recipients_id);
        if (recipients != null){
            return R.ok(recipients);
        }else {
            return  R.error("查询失败");
        }
    }

    @Override
    public R selectRecipients() {
        List<Recipients> recipients = recipientsDao.selectRecipients();
        HashMap<String, Object> map = new HashMap<>();
        map.put("recipients" , recipients);
        if (map != null) {
            return R.ok(map);
        }else  {
            return  R.error("查询失败");
        }
    }

    @Override
    public R insertRecipients(Recipients recipients) {
        int i = recipientsDao.insertRecipients(recipients);
        if (i == 1) {
            return R.ok();
        } else {
            return R.error("添加失败");
        }

    }
}
