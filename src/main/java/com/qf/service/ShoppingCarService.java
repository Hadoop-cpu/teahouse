package com.qf.service;

import com.qf.dto.ShoppingCarDto;
import com.qf.pojo.ShoppingCar;
import com.qf.vo.R;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ShoppingCarService {

    //根据用户id查询其购物车中的商品信息
    R selectShoppingCarByUserId(HttpServletRequest request);

    //删除用户购物车中的单个商品
    R deleteGoodsInShoppingCarById(Integer carId);

    //将某商品添加到购物车
    R insertGoodsInShoppingCarByGoodsId(Integer userId, Integer goodsId);

    //改变购物车种指定商品的数量
    R updateGoodsNumInShoppingByCarId(Integer carId, Integer goodsNum);

    //将购物车中的指定商品数量+1
    R carGoodsNumAddOne(Integer carId);

    //将购物车中的指定商品数量-1
    R carGoodsNumTallyDown(Integer carId);

    //批量删除
    R deleteAllGoodsInShoppingCarById(Integer userId, Integer[] carIds);

    //查询购物车商品总数
    R queryGoodsNumInShoppingCar(HttpServletRequest request);

    //查询购物车中选中商品商城价的总价
    R queryGoodsShopPriceSumByCarId(Integer[] carIds);

    //查询购物车中选中商品   市场价   的总价
    R queryGoodsMarketPriceSumByCarId(Integer[] carIds);

}
