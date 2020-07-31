package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.pojo.Recipients;
import com.qf.service.RecipientsService;
import com.qf.vo.R;
import com.sun.org.glassfish.gmbal.ParameterNames;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Map;

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
    @GetMapping("/deleteRecipientsByRecipId/{id}")
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
    public R updateRecipients(@RequestBody Recipients recipients) {
        return recipientsService.updateRecipients(recipients);
    }
    /*
    根据user_id查询收货人所有的信息
     */

    @ApiOperation(value = "根据用户id查询所有收货人信息")
    @GetMapping("/selectRecipients")
    public R selectRecipients(HttpServletRequest request) {
        return recipientsService.selectRecipientsByUserId(request);
    }
    @ApiOperation(value = "根据地址id查询收货人信息")
    @GetMapping("selectRecipientsByOne/{id}")
    public R selectRecipientsByOne(@PathVariable int id) {
        return recipientsService.selectRecipientsByOne(id);
    }

    @ApiOperation(value = "添加收货人信息")
    @PostMapping("/insertRecipients")
    public R insertRecipients(@RequestBody Recipients recipients) {
        return recipientsService.insertRecipients(recipients);
    }




}
