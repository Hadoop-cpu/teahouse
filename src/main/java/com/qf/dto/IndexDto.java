package com.qf.dto;

import lombok.Data;

@Data
public class IndexDto {
    private String goods_name;
    private Double goods_market_price;  //商品市场价
    private Double goods_shop_price;    //商品商城价
    private Integer goods_sales;        //商品销售额
    private Integer img_main;          //商品图片，关联图片表



}
