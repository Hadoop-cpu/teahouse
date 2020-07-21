package com.qf.service.impl;

import com.qf.dao.ShoppingCarDao;
import com.qf.service.ShoppingCarService;
import com.qf.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarDao shoppingCarDao;

    //根据用户id查询购物车
    @Override
    public R selectShoppingCarByUserId(Integer userId) {
        if (userId == null){
            return R.error("用户id为空");
        } else {
            List<Map<String, Object>> maps = shoppingCarDao.selectShoppingCarByUserId(userId);
            if (maps == null){
                return R.error("购物车里没有任何东西");
            } else {
                return R.ok(maps);
            }
        }
    }

    //删除单个商品
    @Override
    public R deleteGoodsInShoppingCarById(Integer userId, Integer carId) {
        //参数判断
        if (userId == null && carId == null){
            return R.error("输入参数有误");
        } else {
            //调用删除方法
            int i = shoppingCarDao.deleteGoodsInShoppingCarById(userId, carId);

            if (i != 1){
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
        if (userId == null && goodsId == null){
            return R.error("信息输入有误");
        } else {
            //先查询该用户购物车里是否有该商品
            //查询用户购物车
            List<Map<String, Object>> list = shoppingCarDao.selectShoppingCarByUserId(userId);
            //遍历查找对应的goodsId
            for (Map<String, Object> map : list) {
                //此时购物车中有对应商品
                if (map.get("goods_id") == goodsId){
                    //获取购物车ID
                    Integer car_id = (Integer) map.get("car_id");
                    //获取对应商品数量
                    Integer car_goods_num = (Integer) map.get("car_goods_num");
                    //调用改变数量的方法，使数量+1
                    int i = shoppingCarDao.updateGoodsNumInShoppingByCarId(car_id, car_goods_num + 1);
                    if (i != 1){
                        return R.error("添加有误");
                    } else {
                        return R.ok();
                    }
                }
            }
            //如果没有此商品则调用添加方法
            int i = shoppingCarDao.insertGoodsInShoppingCarByGoodsId(userId, goodsId);
            if (i != 1){
                return R.error("添加失败");
            } else {
                return R.ok();
            }
        }
    }

    //改变购物车商品数量
    @Override
    public R updateGoodsNumInShoppingByCarId(Integer carId, Integer goodsNum) {
        if (carId == null && goodsNum == null){
            return R.error("输入参数不合法");
        } else {
            //对商品数量进行判断，商品数量不能小于1
            if (goodsNum < 1){
                return R.error("亲，数量不能更少了哦");
            } else {
                //商品合法，正常开始根据传来的数字修改商品数量
                int i = shoppingCarDao.updateGoodsNumInShoppingByCarId(carId, goodsNum);
                if (i != 1){
                    return R.error("修改出现BUG");
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

    @Override
    public R queryGoodsNumInShoppingCar(Integer userId) {
        if (userId == null){
            return R.error("用户信息有误");
        } else {
            int i = shoppingCarDao.queryGoodsNumInShoppingCar(userId);
            return R.ok(i);
        }
    }

    @Override
    public R queryGoodsShopPriceSumByCarId(Integer[] carIds) {

        if (carIds == null){
            return R.error("选中参数有误");
        } else {
            List<Map<String, Object>> list = shoppingCarDao.queryGoodsShopPriceSumByCarId(carIds);

            if (list == null){
                return R.error("总价计算错误");
            } else {
                Double goodsShopPriceSum = 0.00;

                for (Map<String, Object> map : list) {
                    Double goods_shop_price = (Double) map.get("goods_shop_price");
                    Integer car_goods_num = (Integer) map.get("car_goods_num");

                    goodsShopPriceSum += (goods_shop_price * car_goods_num);
                }

                System.out.println(goodsShopPriceSum);
                return R.ok(goodsShopPriceSum);
            }

        }
    }

}
