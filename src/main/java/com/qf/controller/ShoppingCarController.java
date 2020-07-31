package com.qf.controller;

import com.qf.service.ShoppingCarService;
import com.qf.util.JedisCore;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@Api(tags = "购物车相关")
@RequestMapping("ShoppingCar/")
public class ShoppingCarController {

    @Autowired
    private ShoppingCarService shoppingCarService;


    //根据用户id查询购物车
    @ApiOperation(value = "根据用户id查询购物车")
    @PostMapping("selectShoppingCarByUserId")
    public R selectShoppingCarByUserId(HttpServletRequest request){
        return shoppingCarService.selectShoppingCarByUserId(request);
    }

    @ApiOperation(value = "根据商品Id删除商品")
    @GetMapping("deleteGoodsInShoppingCarById/{carId}")
    public R deleteGoodsInShoppingCarById(@PathVariable("carId") Integer carId){
        return shoppingCarService.deleteGoodsInShoppingCarById(carId);
    }

    @ApiOperation(value = "根据商品Id添加到购物车")
    @PostMapping("insertGoodsInShoppingCarByGoodsId")
    public R insertGoodsInShoppingCarByGoodsId(Integer userId, Integer goodsId){
        return shoppingCarService.insertGoodsInShoppingCarByGoodsId(userId, goodsId);
    }

    //@ApiOperation(value = "根据商品Id添加到购物车")
    @PostMapping("carGoodsNumAddOne")
    public R carGoodsNumAddOne(Integer carId){
        return shoppingCarService.carGoodsNumAddOne(carId);
    }

    //@ApiOperation(value = "根据商品Id添加到购物车")
    @PostMapping("carGoodsNumTallyDown")
    public R carGoodsNumTallyDown(Integer carId){
        return shoppingCarService.carGoodsNumTallyDown(carId);
    }

    @ApiOperation(value = "根据商品Id修改购物车商品数量")
    @PostMapping("updateGoodsNumInShoppingByCarId")
    public R updateGoodsNumInShoppingByCarId(Integer carId, Integer goodsNum){
        return shoppingCarService.updateGoodsNumInShoppingByCarId(carId, goodsNum);
    }

    @ApiOperation(value = "根据购物车Id删除整个购物车")
    @PostMapping("deleteAllGoodsInShoppingCarById")
    public R deleteAllGoodsInShoppingCarById(Integer userId, Integer[] carIds){
        return shoppingCarService.deleteAllGoodsInShoppingCarById(userId, carIds);
    }


    //@ApiOperation(value = "根据商品Id添加到购物车")
    @PostMapping("queryGoodsNumInShoppingCar")
    public R queryGoodsNumInShoppingCar(HttpServletRequest request){
        return shoppingCarService.queryGoodsNumInShoppingCar(request);
    }

    //@ApiOperation(value = "根据商品Id添加到购物车")
    @PostMapping("queryGoodsShopPriceSumByCarId")
    public R queryGoodsShopPriceSumByCarId(Integer[] carIds){
        return shoppingCarService.queryGoodsShopPriceSumByCarId(carIds);
    }

   // @ApiOperation(value = "根据商品Id添加到购物车")
    @PostMapping("queryGoodsMarketPriceSumByCarId")
    public R queryGoodsMarketPriceSumByCarId(Integer[] carIds){
        return shoppingCarService.queryGoodsMarketPriceSumByCarId(carIds);
    }


}
