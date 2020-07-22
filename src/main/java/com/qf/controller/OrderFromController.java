package com.qf.controller;



import com.qf.dto.OrderFromDto;
import com.qf.service.OrderFromService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ClassName: OrderFromController
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 20:18
 */
@Api(tags = "茶小屋 订单相关接口" )
@RestController
@RequestMapping("orderFrom")
public class OrderFromController {
    @Autowired
    private OrderFromService service;

    //查询个人订单 (没用ov)
//    @GetMapping("/finAll")
//    public List<OrderFromDto> findAll(Integer user_id ){
//        return service.findAll(user_id);
//    }

    //查询个人订单
    @ApiOperation(value="查询个人历史订单")
    @GetMapping("/finAll")
    public R findAll(Integer user_id ){
        service.findAll(user_id);
       // System.out.println(all + "++++++");
        return (service.findAll(user_id));
    }
    //提交个人订单详细信息

    @ApiOperation(value="订单详细信息")
    @GetMapping("/finOrder")
    public R  findOrder(Integer car_id){
        R order = service.findOrder(car_id);
        // System.out.println(all + "++++++");
        return order;
    }



    //确认订单

    /*@GetMapping("/insertOrderFrom")
    public R insertOrderFrom(OrderFromDto dto) {
        R r = service.insertOrderFrom(dto);
        return R.ok(r);
    }
*/

}
