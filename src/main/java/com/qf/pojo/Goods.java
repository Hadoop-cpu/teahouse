package com.qf.pojo;

import lombok.Data;

/**
 * @ClassName: Goods
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 10:47
 */
@Data
public class Goods {

    private Integer goods_id;           //商品id
    private String goods_name;          //商品名称
    private Integer goods_putaway;      //是否上架，0是1否
    private String goods_info;          //商品详情
    private Integer goods_img;          //商品图片，关联图片表
    private Integer goods_brand;        //商品品牌、关联品牌表
    private Integer goods_variety;      //茶叶品种、关联品种表、若商品非茶叶商品，此字段可以为空
    private Integer goods_type_id;      //商品类型，关联商品类型表
    private Double goods_market_price;  //商品市场价
    private Double goods_shop_price;    //商品商城价
    private Integer goods_inventory;    //商品库存
    private Integer goods_sales;        //商品销售额

}
