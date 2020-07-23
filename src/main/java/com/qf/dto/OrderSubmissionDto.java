package com.qf.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: OrderSubmissionDto
 * @Author: 王赛
 * @Date: 2020/7/22
 * @Time: 15:11
 */
@Data
public class OrderSubmissionDto {
    private String goods_name;
    private Integer car_goods_num;
    //private Integer user_id;
    private Integer car_id;
    private Integer order_price;
}
