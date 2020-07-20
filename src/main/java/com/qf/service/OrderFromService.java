package com.qf.service;



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

    R findAll(Integer user_id);

}
