package com.qf.dao;


import com.qf.dto.OrderFromDto;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: OrderDao
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 15:28
 */
@Repository
public interface OrderFromDao {


    //订单个人查询
//    @Select("SELECT goods.goods_name, orderfrom.creation_time, shoppingcar.car_goods_num, user.user_id, orderfrom.order_id, orderfrom.order_flag, orderfrom.order_price from user, shoppingcar, goods, orderfrom WHERE user.user_id = shoppingcar.user_id and goods.goods_id = shoppingcar.goods_id and shoppingcar.order_id = orderfrom.order_id and user.user_id = #{user_id}")
//    List<Map<String,Object>> findAll(Integer user_id);

    //订单个人查询
    @Select("SELECT goods.goods_name, orderfrom.creation_time, shoppingcar.car_goods_num, user.user_id, orderfrom.order_id, orderfrom.order_flag, orderfrom.order_price from user, shoppingcar, goods, orderfrom WHERE user.user_id = shoppingcar.user_id and goods.goods_id = shoppingcar.goods_id and shoppingcar.order_id = orderfrom.order_id and user.user_id = #{user_id}")
    List<OrderFromDto> findAl(Integer user_id);
}
