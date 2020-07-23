package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: shoppingcar
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 10:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCar {

    private Integer car_id;          //购物车id
    private Integer goods_id;        //商品id
    private Integer user_id;         //所属用户Id
    private Integer car_goods_num;   //购物车中的商品数量

}

