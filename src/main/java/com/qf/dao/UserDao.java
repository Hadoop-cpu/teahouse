package com.qf.dao;

import com.qf.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserDao
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 11:22
 */
@Repository
public interface UserDao {
    //修改user信息
    int updateUser(User user);
    //根据id查询用户信息
    User selectUserById(int user_id);
}
