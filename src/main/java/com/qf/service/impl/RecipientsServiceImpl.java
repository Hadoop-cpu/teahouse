package com.qf.service.impl;

import com.qf.dao.RecipientsDao;
import com.qf.pojo.Recipients;
import com.qf.service.RecipientsService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RecipientsServiceImpl implements RecipientsService {
    @Autowired
    private RecipientsDao recipientsDao;

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
    public R selectRecipientsByUserId(Integer user_id) {
        List<Recipients> recipientsList = recipientsDao.selectRecipientsByUserId(user_id);
        if (null != recipientsList) {
            return R.ok(recipientsList);
        } else {
            return R.error("查询失败");
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
}
