package com.qf.pojo;

import lombok.Data;

/**
 * @ClassName: recipients
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 10:36
 */
@Data
public class Recipients {

    private Integer recipients_id;      //收件人信息id
    private String recipients_user_id;  //关联的用户id
    private Integer recipients_name;    //名字
    private Integer recipients_phone;   //收件电话
    private Integer recipients_address; //地址

}
