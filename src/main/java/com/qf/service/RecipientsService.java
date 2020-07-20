package com.qf.service;

import com.qf.pojo.Recipients;
import com.qf.vo.R;

import java.util.List;

public interface RecipientsService {

    //修改Recipients信息
    R updateRecipients(Recipients recipients);
    //删除Recipients信息
    R deleteRecipientsByRecipId(Integer recipients_id);
    //查询Recipients信息
    R selectRecipientsByUserId(Integer user_id);
}
