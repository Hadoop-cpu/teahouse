package com.qf.service;



import com.qf.dto.OrderFromDto;
import com.qf.vo.R;

/**
 * @ClassName: OrderFromService
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 20:09
 */
public interface OrderFromService {

    //订单个人查询
    //List<Map<String,Object>> findAll(Integer user_id);

    //订单个人查询(没用ov)
   // List<OrderFromDto> findAll(Integer user_id);

    //订单个人查询
    R findAll(Integer user_id);

    //提交个人订单详细信息
    R findOrder(Integer car_id);

    //确认订单
    R insertOrderFrom (OrderFromDto dto);
}
