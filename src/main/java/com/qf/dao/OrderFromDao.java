package com.qf.dao;

import com.qf.dto.GoodsDto;
import com.qf.dto.OrderFromDto;
import com.qf.dto.OrderSubmissionDto;
import com.qf.dto.ShoppingCarDto;

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

    //确认订单 (添加 订单ID 订单号 订单状态 商品ID 用户Id 购买数量 购物车Id 订单时间 价格)

    int insertOrderFrom(OrderFromDto dto);

    int insertGoodsById(GoodsDto dto);

    int insertShoppingCar(ShoppingCarDto dto);

    //订单个人查询
    //@Select("SELECT goods.goods_name, orderfrom.creation_time, shoppingcar.car_goods_num, user.user_id, orderfrom.order_id, orderfrom.order_flag, orderfrom.order_price from user, shoppingcar, goods, orderfrom WHERE user.user_id = shoppingcar.user_id and goods.goods_id = shoppingcar.goods_id and shoppingcar.order_id = orderfrom.order_id and user.user_id = #{user_id}")
    //List<Map<String,Object>> findAll(Integer user_id);

    //订单个人查询
    @Select("SELECT goods.goods_name, orderfrom.creation_time, shoppingcar.car_goods_num, user.user_id, orderfrom.order_id, orderfrom.order_flag, orderfrom.order_price from user, shoppingcar, goods, orderfrom WHERE user.user_id = shoppingcar.user_id and goods.goods_id = shoppingcar.goods_id and user.user_id = #{user_id}")
    List<OrderFromDto> findAll(Integer user_id);

    //提交个人订单详细信息
    @Select("SELECT goods.goods_name, shoppingcar.car_goods_num, orderfrom.order_price, shoppingcar.car_id FROM orderfrom, goods, shoppingcar WHERE goods.goods_id = shoppingcar.goods_id and shoppingcar.car_id =#{car_id}")
    List<OrderSubmissionDto> findOrder(Integer car_id);



}
