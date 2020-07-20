package com.qf.config;

import com.qf.constant.SystemConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SwaggerConfig
 * @Author: 王赛
 * @Date: 2020/7/15
 * @Time: 19:08
 */

@Configuration //配置文件
//@EnableSwagger2WebMvc//启用Swagger
@EnableSwagger2//启用Swagger

public class SwaggerConfig {

    public ApiInfo createAI(){
        //创建文档说明
        ApiInfo apiInfo = new ApiInfoBuilder().
                title("茶小屋后端接口文档").
                description("茶小屋项目的所有接口信息，可以查看对应得接口信息和对接口进行测试").
                contact(new Contact("茶小屋团队", "http://localhost:8080/doc.html","Hadoop_CPU@163.com")).
                build();
        return apiInfo;
    }
    // 创建Swagger扫描信息
    @Bean
    public Docket creatD(){

        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name(SystemConstant.TOKEN_HEADER).description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        //添加head参数配置end
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createAI())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qf.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);//注意这里

    }
}
