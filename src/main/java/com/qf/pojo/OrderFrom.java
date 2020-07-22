package com.qf.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: OrderFrom
 * @Author: 王赛
 * @Date: 2020/7/21
 * @Time: 14:39
 */
@Data
public class OrderFrom {
    private Integer order_id;
    private String order_uuid;
    private Integer order_flag;
    private Integer recipients_id;
    private Integer user_id;
    private Integer car_id;
    private Date creation_time;
    private Double order_price;

}
