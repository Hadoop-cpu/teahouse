package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: recipients
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 10:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipients {

    private Integer recipients_id;      //收件人信息id
    private Integer recipients_user_id;  //关联的用户id
    private String recipients_name;    //名字
    private String recipients_phone;   //收件电话
    private String recipients_address; //地址

}
