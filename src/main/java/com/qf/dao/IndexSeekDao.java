package com.qf.dao;

import com.qf.dto.IndexDto;
import com.qf.pojo.GoodsBrand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: IndexSeekDao
 * @Author: 蒋福林
 * @Date: 2020/7/21
 * @Time: 19：46
 */
@Repository
public interface IndexSeekDao {

/*    //根据名字进行模糊查找，输入查找功能
    @Select("SELECT goods_name, goods_market_price, goods_shop_price,goods_sales, img_main" +
            " FROM goods g ,goods_img i" +
            " WHERE g.goods_img = i.img_id AND goods_name" +
            " LIKE '%#{goods_name}%' limit #{pageNo}, #{pageSize}")
    List<IndexDto> indexSeek (@Param("goods_name") String goods_name, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Select("SELECT COUNT(*) FROM (SELECT goods_name, goods_market_price, goods_shop_price,goods_sales, img_main FROM goods g ,goods_img i WHERE g.goods_img=i.img_id AND goods_name LIKE '%#{goods_name}%') i")
    int count (String goods_name);*/

    //输入框模糊查询
    @Select("SELECT goods_name, goods_market_price, goods_shop_price,goods_sales, img_main\n" +
            " FROM goods g ,goods_img i\n" +
            " WHERE g.goods_img = i.img_id\n" +
            " AND goods_name LIKE #{goods_name}")
    List<IndexDto> indexSeek(String goods_name);

    //根据评判展示相应商品
    @Select("SELECT goods_name, goods_market_price, goods_shop_price,goods_sales, img_main\n" +
            "FROM goods g, goods_img i\n" +
            "WHERE g.goods_img = i.img_id\n" +
            "AND g.goods_brand = #{goods_brand}")
    List<IndexDto> indexByBrand(int goods_brand);

    @Select("SELECT goods_name, goods_market_price, goods_shop_price,goods_sales, img_main\n" +
            "FROM goods g, goods_img i\n" +
            "WHERE g.goods_img =i.img_id\n" +
            "AND g.goods_type_id = (\n" +
            "SELECT variety_id\n" +
            "FROM goods_variety WHERE variety_name = #{variety_name})")
    List<IndexDto> indexByVariety(String variety_name);
}


