package com.qf;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

@EnableSwagger2 //启用事务

@MapperScan("com.qf.dao")//扫描包
public class TeahouseApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TeahouseApplication.class, args);
    }

}
