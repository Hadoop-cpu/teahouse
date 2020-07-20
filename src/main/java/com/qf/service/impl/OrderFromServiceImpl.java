package com.qf.service.impl;

import com.qf.dao.OrderFromDao;
import com.qf.dto.OrderFromDto;
import com.qf.service.OrderFromService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName: OrderFromServiceImpl
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 20:10
 */
@Service
public class OrderFromServiceImpl implements OrderFromService {

    @Autowired
    private OrderFromDao dao;


    //订单个人查询
//    @Override
//    public List<Map<String,Object>> findAll(Integer user_id) {
//
//        return dao.findAll(user_id);
//    }

    //订单个人查询(没有vo)
//    @Override
//    public List<OrderFromDto> findAll(Integer user_id) {
//        return dao.findAl(user_id);
//    }
    @Override
    public R findAll(Integer user_id) {

        List<OrderFromDto> list = dao.findAl(user_id);

        return R.ok(list);
    }

}