package com.qf.controller;

import com.qf.service.ShoppingCarService;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "购物车相关")
@RequestMapping("ShoppingCar/")
public class ShoppingCarController {

    @Autowired
    private ShoppingCarService shoppingCarService;

    //根据用户id查询购物车
    @PostMapping("selectShoppingCarByUserId")
    public R selectShoppingCarByUserId(Integer userId){
        return shoppingCarService.selectShoppingCarByUserId(userId);
    }

    @PostMapping("deleteGoodsInShoppingCarById")
    public R deleteGoodsInShoppingCarById(Integer userId, Integer carId){
        return shoppingCarService.deleteGoodsInShoppingCarById(userId, carId);
    }

    @PostMapping("insertGoodsInShoppingCarByGoodsId")
    public R insertGoodsInShoppingCarByGoodsId(Integer userId, Integer goodsId){
        return shoppingCarService.insertGoodsInShoppingCarByGoodsId(userId, goodsId);
    }

    @PostMapping("carGoodsNumAddOne")
    public R carGoodsNumAddOne(Integer carId, Integer goodsNum){
        return shoppingCarService.updateGoodsNumInShoppingByCarId(carId, goodsNum + 1);
    }

    @PostMapping("carGoodsNumTallyDown")
    public R carGoodsNumTallyDown(Integer carId, Integer goodsNum){
        return shoppingCarService.updateGoodsNumInShoppingByCarId(carId, goodsNum - 1);
    }

    @PostMapping("updateGoodsNumInShoppingByCarId")
    public R updateGoodsNumInShoppingByCarId(Integer carId, Integer goodsNum){
        return shoppingCarService.updateGoodsNumInShoppingByCarId(carId, goodsNum);
    }

    @PostMapping("deleteAllGoodsInShoppingCarById")
    public R deleteAllGoodsInShoppingCarById(Integer userId, Integer[] carIds){
        return shoppingCarService.deleteAllGoodsInShoppingCarById(userId, carIds);
    }

    @PostMapping("queryGoodsNumInShoppingCar")
    public R queryGoodsNumInShoppingCar(Integer userId){
        return shoppingCarService.queryGoodsNumInShoppingCar(userId);
    }

    @PostMapping("queryGoodsPriceInShoppingCar")
    public R queryGoodsPriceInShoppingCar(Integer[] carIds){
        return shoppingCarService.queryGoodsPriceInShoppingCar(carIds);
    }

}
