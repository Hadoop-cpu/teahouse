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

    private Integer carId;          //购物车id
    private Integer goodsId;        //商品id
    private Integer userId;         //所属用户Id
    private Integer carGoodsNum;    //购物车中的商品数量

}
