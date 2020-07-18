package com.qf.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: HungryApi
 * @description: 封装操作Redis方法
 * @author: Feri(邢朋辉)
 * @create: 2020-06-18 10:19
 */

//redis 方法封装
public class JedisCore {

    private Jedis jedis;

    public JedisCore(String host,int port,String pass){
        JedisPool pool=new JedisPool(host,port);
        jedis=pool.getResource();
        jedis.auth(pass);
    }
    //新增
    public void set(String key,String val,int seconds){
        jedis.setex(key,seconds,val);
    }
    //删除
    public void del(String key){
        jedis.del(key);
    }
    //查询
    public String get(String key){
        return jedis.get(key);
    }

    //系统
    public boolean checkKey(String key){
        return jedis.exists(key);
    }

    public long ttl(String key){
        return jedis.ttl(key);
    }
    public int keys(String key){
        return jedis.keys(key).size();
    }

    public void expire(String key,int seconds){
        jedis.expire(key,seconds);
    }

}
