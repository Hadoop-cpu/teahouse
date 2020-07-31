package com.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.qf.config.RedisKeyConfig;
import com.qf.dao.ShoppingCarDao;
import com.qf.dto.ShoppingCarDto;
import com.qf.pojo.ShoppingCar;
import com.qf.pojo.User;
import com.qf.service.ShoppingCarService;
import com.qf.util.JedisCore;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarDao shoppingCarDao;
    @Autowired
    private JedisCore jedisCore;

    //根据用户id查询购物车
    @Override
    public R selectShoppingCarByUserId(HttpServletRequest request) {

        String token = request.getHeader("token");

            if (token == null || token =="" || !jedisCore.checkKey(RedisKeyConfig.TOKEN_USER + token)){
                return R.error("用户未登录");
            }else {
            User user = JSON.parseObject(jedisCore.get(RedisKeyConfig.TOKEN_USER + token), User.class);

            Integer user_id = user.getUser_id();

            List<ShoppingCarDto> list = shoppingCarDao.selectShoppingCarByUserId(user_id);
            if (list == null) {
                return R.error("购物车里没有任何东西");
            } else {
                return R.ok(list);
            }
        }
    }

    //删除单个商品
    @Override
    public R deleteGoodsInShoppingCarById(Integer carId) {

        System.out.println("carId = " + carId);


        //参数判断
        if (carId == null) {
            return R.error("输入参数有误");
        } else {
            //调用删除方法
            int i = shoppingCarDao.deleteGoodsInShoppingCarById(carId);

            if (i != 1) {
                return R.error("删除失败");
            } else {
                return R.ok();
            }
        }
    }

    //购物车添加商品
    @Override
    public R insertGoodsInShoppingCarByGoodsId(Integer userId, Integer goodsId) {
        //参数判断
        if (userId == null && goodsId == null) {
            return R.error("信息输入有误");
        } else {
            //先查询该用户购物车里是否有该商品
            List<ShoppingCarDto> shoppingCarList = shoppingCarDao.selectShoppingCarByUserId(userId);
            //遍历查找对应的goodsId
            for (ShoppingCarDto shoppingCarDto : shoppingCarList) {
                //得到goodsId
                Integer goods_id = shoppingCarDto.getGoods_id();
                //此时购物车中有对应商品
                if (goods_id == goodsId){
                    //得到商品数量
                    Integer car_goods_num = shoppingCarDto.getCar_goods_num();
                    //得到购物车Id
                    Integer car_id = shoppingCarDto.getCar_id();
                    //改变数量
                    shoppingCarDao.updateGoodsNumInShoppingByCarId(car_id, car_goods_num + 1);
                    return R.ok();
                }
            }
            //如果没有此商品则调用添加方法
            int i = shoppingCarDao.insertGoodsInShoppingCarByGoodsId(new ShoppingCar(null, goodsId, userId, 1));
            if (i != 1) {
                return R.error("添加失败");
            } else {
                return R.ok();
            }
        }
    }

    //改变购物车商品数量
    @Override
    public R updateGoodsNumInShoppingByCarId(Integer carId, Integer goodsNum) {
        if (carId == null && goodsNum == null) {
            return R.error("输入参数不合法");
        } else {
            //对商品数量进行判断，商品数量不能小于1
            if (goodsNum < 1) {
                return R.error("亲，数量不能更少了哦");
            } else {
                //商品合法，正常开始根据传来的数字修改商品数量
                int i = shoppingCarDao.updateGoodsNumInShoppingByCarId(carId, goodsNum);
                if (i != 1) {
                    return R.error("修改出现BUG");
                } else {
                    return R.ok();
                }
            }
        }
    }

    @Override
    public R carGoodsNumAddOne(Integer carId) {
        if (carId == null) {
            return R.error("输入信息有误");
        } else {
            //查出该商品的数量
            int i = shoppingCarDao.queryGoodsNumInShoppingCarByCarId(carId);
            if (i < 1){
                return R.error("商品数量有误");
            } else {
                //调用改变数量方法
                int r = shoppingCarDao.updateGoodsNumInShoppingByCarId(carId, i + 1);
                if (r != 1) {
                    return R.error("商品添加失败");
                } else {
                    return R.ok();
                }
            }
        }
    }

    @Override
    public R carGoodsNumTallyDown(Integer carId) {
        if (carId == null) {
            return R.error("输入信息有误");
        } else {
            //查出商品数量
            int i = shoppingCarDao.queryGoodsNumInShoppingCarByCarId(carId);
            if (i < 2) {
                return R.error("亲，数量不能更少了哦");
            } else {
                //修改数量
                int r = shoppingCarDao.updateGoodsNumInShoppingByCarId(carId, i - 1);
                if (r != 1) {
                    return R.error("修改失败");
                } else {
                    return R.ok();
                }
            }
        }
    }

    //批量删除
    @Override
    public R deleteAllGoodsInShoppingCarById(Integer userId, Integer[] carIds) {
        if (userId == null && carIds == null){
            return R.error("输入信息有误");
        } else {
            int i = shoppingCarDao.deleteAllGoodsInShoppingCarById(userId, carIds);
            if (i != carIds.length){
                return R.error("删除有误");
            } else {
                return R.ok();
            }
        }
    }

    //@查询购物车总商品数量
    @Override
    public R queryGoodsNumInShoppingCar(HttpServletRequest request) {

        String token = request.getHeader("token");

        if (token == null || token =="" || !jedisCore.checkKey(RedisKeyConfig.TOKEN_USER + token)){
            return R.error("用户未登录");
        }else {
            User user  = JSON.parseObject(jedisCore.get(RedisKeyConfig.TOKEN_USER + token), User.class);

            Integer user_id = user.getUser_id();

            int i = shoppingCarDao.queryGoodsNumInShoppingCar(user_id);
            return R.ok(i);
        }
    }

    //查询总商城价    暫時不用
    @Override
    public R queryGoodsShopPriceSumByCarId(Integer[] carIds) {

        if (carIds == null){
            return R.error("选中参数有误");
        } else {
            List<ShoppingCarDto> list = shoppingCarDao.queryGoodsShopPriceSumByCarId(carIds);
            if (list == null){
                return R.error("总价计算错误");
            } else {
                //总价
                Double goodsShopPriceSum = 0.00;
                for (ShoppingCarDto shoppingCarDto : list) {
                    //获取商品数量
                    Integer car_goods_num = shoppingCarDto.getCar_goods_num();
                    //获取商城总价
                    Double goods_shop_price = shoppingCarDto.getGoods_shop_price();
                    //计算总价
                    goodsShopPriceSum += (car_goods_num * goods_shop_price);
                }
                return R.ok(goodsShopPriceSum);
            }
        }
    }




    @Override
    public R queryGoodsMarketPriceSumByCarId(Integer[] carIds) {
        if (carIds == null){
            return R.error("选中参数有误");
        } else {
            List<ShoppingCarDto> list = shoppingCarDao.queryGoodsMarketPriceSumByCarId(carIds);
            if (list == null){
                return R.error("总价计算错误");
            } else {
                //总价
                Double goodsMarketPriceSum = 0.00;
                for (ShoppingCarDto shoppingCarDto : list) {
                    //获取商品数量
                    Integer car_goods_num = shoppingCarDto.getCar_goods_num();
                    //获取商城总价
                    Double goods_market_price = shoppingCarDto.getGoods_market_price();
                    //计算总价
                    goodsMarketPriceSum += (car_goods_num * goods_market_price);
                }
                return R.ok(goodsMarketPriceSum);
            }

        }
    }
}

