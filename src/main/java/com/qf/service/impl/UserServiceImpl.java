package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public R updateUser(User user) {
        int i = userDao.updateUser(user);
        if (i == 1) {
            return R.ok();
        } else {
            return R.error("修改失败");
        }
    }

    @Override
    public R selectUserById(Integer user_id) {
        User user = userDao.selectUserById(user_id);
        if (user == null) {
            return R.error("查询失败");
        } else {
            System.out.println(R.ok(user));
            R ok = R.ok(user);
            return ok;
        }
    }
}
