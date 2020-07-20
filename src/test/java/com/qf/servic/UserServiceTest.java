package com.qf.servic;

import com.qf.TeahouseApplication;
import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.vo.R;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TeahouseApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSelectUserById() {
        R r = userService.selectUserById(2);
        System.out.println(r);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(1,null,"12345","112327711@163.com","小白",'女',null);
        userService.updateUser(user);
    }
}
