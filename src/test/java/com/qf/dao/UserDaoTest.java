package com.qf.dao;

import com.qf.TeahouseApplication;
import com.qf.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TeahouseApplication.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectUserById() {
        User user = userDao.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1,null,"12345","112327711@qq.com","小白",'女',null);
        userDao.updateUser(user);
    }

}
