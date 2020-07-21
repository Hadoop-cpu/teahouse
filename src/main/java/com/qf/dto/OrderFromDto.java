package com.qf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: OrderFromDto
 * @Author: 王赛
 * @Date: 2020/7/19
 * @Time: 9:10
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderFromDto {

    private String goods_name;
    private Date creation_time;
    private Integer car_goods_num;
    private Integer user_id;
    private Integer order_id;
    private Integer order_flag;
    private Integer order_price;

}
