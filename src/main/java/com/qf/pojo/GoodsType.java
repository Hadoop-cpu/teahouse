package com.qf.pojo;

import lombok.Data;


/**
 * @ClassName: GoodsType
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 10:42
 */
@Data
public class GoodsType {
    private Integer type_id;        //商品类型Id
    private Integer type_num;       //商品类型名称、袋装、铁盒、礼盒
    private Double market_price;    //符合该类型的商品数量
    private Double type_price;      //商品市场价
    private String type_name;       //商品商城价

}
