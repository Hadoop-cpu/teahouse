package com.qf.config;

import com.qf.util.JedisCore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: JedisConfig
 * @Author: 王赛
 * @Date: 2020/7/15
 * @Time: 16:02
 */
@Configuration
//redis配置类
public class JedisConfig {
    @Value("${voter.redis.host}")
    private String host;
    @Value("${voter.redis.port}")
    private int port;
    @Value("${voter.redis.pass}")
    private String pass;
    @Value("${voter.redis.maxTotal}")
    private int maxTotal;
    @Value("${voter.redis.maxIdle}")
    private int maxIdle;

    @Bean
    public JedisCore createJC(){
        return new JedisCore(maxTotal,maxIdle,host,port,pass);
    }
}
