package com.qf.controller;

import com.qf.pojo.Recipients;
import com.qf.service.RecipientsService;
import com.qf.vo.R;
import com.sun.org.glassfish.gmbal.ParameterNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @ClassName: RecipientsController
 * @Author: 马陈浩
 * @Date: 2020/7/20
 * @Time: 11:23
 */
@Api(tags = "茶小屋 用户相关接口")
@RestController
@CrossOrigin
@RequestMapping("/recipients")
public class RecipientsController {
    @Autowired
    private RecipientsService recipientsService;

    /**
     * 根据recipients_id删除收货人信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "根据id删除收货人信息")
    @PostMapping("/deleteRecipients/{id}")
    public R deleteRecipients(@PathVariable int id) {
        return recipientsService.deleteRecipientsByRecipId(id);
    }

    /**
     * 根据recipients_id修改收货人信息
     *
     * @param recipients
     * @return
     */
    @ApiOperation(value = "根据id修改收货人信息")
    @PostMapping("/updateRecipients")
    public R updateRecipients(Recipients recipients) {
        return recipientsService.updateRecipients(recipients);
    }
    /*
    根据user_id查询收货人所有的信息
     */

    @ApiOperation(value = "根据id查询收货人信息")
    @PostMapping("/selectRecipients/{id}")
    public R selectRecipients(@PathVariable int id) {
        System.out.println("根据id查询收货人信息");
        return recipientsService.selectRecipientsByUserId(id);
    }

    @PostMapping("/selectRecipients")
    public R selectRecipients() {
        return recipientsService.selectRecipients();
    }


}
