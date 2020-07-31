package com.qf.dao;

import com.qf.pojo.Recipients;
import com.qf.vo.R;
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
    //根据id查询Recipients
    Recipients selectRecipientsByOne(Integer recipients_id);
    //添加Recipients信息
    int insertRecipients(Recipients recipients);
    List<Recipients> selectRecipients();
}
