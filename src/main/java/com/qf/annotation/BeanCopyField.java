package com.qf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: BeanCopyFiled
 * @Author: 王赛
 * @Date: 2020/7/17
 * @Time: 21:04
 */

//注解工类
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BeanCopyField {
    String value() ;
}
