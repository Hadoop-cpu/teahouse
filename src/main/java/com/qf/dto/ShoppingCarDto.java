package com.qf.dto;

import com.qf.annotation.BeanCopyField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName:
 * @Author: 王赛
 * @Date: 2020/7/18
 * @Time: 11:23
 */

//负责用户对购物车操作
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCarDto {

    @BeanCopyField("car_id")
    private Integer carId;

    @BeanCopyField("user_id")
    private Integer userId;

    @BeanCopyField("goods_id")
    private Integer goodsId;

    @BeanCopyField("car_goods_num")
    private Integer carGoodsNum;

    @BeanCopyField("goods_name")
    private String goodsName;

    @BeanCopyField("img_main")
    private String imgMain;

    @BeanCopyField("goods_type_id")
    private Integer goods_type_id;

    @BeanCopyField("goods_market_price")
    private Double goods_market_price;

    @BeanCopyField("goods_shop_price")
    private Double goods_shop_price;

}
