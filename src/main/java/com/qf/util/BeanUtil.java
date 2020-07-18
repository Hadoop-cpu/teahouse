package com.qf.util;

import com.qf.annotation.BeanCopyField;

import java.lang.reflect.Field;


/**
 * @ClassName: BeanUtil
 * @Author: 王赛
 * @Date: 2020/7/17
 * @Time: 20:53
 */
public class BeanUtil  {
    public static <T> T copyDto(Class<T> clz, Object dto, Field... fs){
        try {
            //1.获取 pojo 类的实例
            T obj = clz.getDeclaredConstructor().newInstance();

            //2.遍历dto的所有字段
            for ( Field f: fs) {
                String fn;
                //获取注解
                BeanCopyField bcf=f.getAnnotation(BeanCopyField.class);
                if(bcf!=null){
                    fn=bcf.value();
                }else {
                    fn=f.getName();
                }
                //3.获取pojo 是否存在对应的属性
                Field fd= clz.getDeclaredField(fn);
                if(fd!=null){
                    //4.设置是否进行访问校验
                    fd.setAccessible(true);
                    f.setAccessible(true);
                    //5. 设置dto 字段的值到pojo
                    fd.set(obj,f.get(dto));
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
