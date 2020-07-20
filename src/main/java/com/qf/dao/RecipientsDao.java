package com.qf.dao;

import com.qf.pojo.Recipients;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @ClassName: RecipientsDao
 * @Author: 马陈浩
 * @Date: 2020/7/20
 * @Time: 11:22
 */
@Repository
public interface RecipientsDao {

    //修改Recipients信息
    int updateRecipients(Recipients recipients);
    //删除Recipients信息
    int deleteRecipientsByRecipId(Integer recipients_id);
    //查询Recipients信息
    List<Recipients> selectRecipientsByUserId(Integer user_id);
}
