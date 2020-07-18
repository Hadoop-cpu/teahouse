package com.qf.util;

/**
 * @ClassName: StringUtil
 * @Author: 王赛
 * @Date: 2020/7/17
 * @Time: 16:12
 */
public class StringUtil {
    //校验字符串是否为空
    public static boolean checkEmpty(String str){
        if (str!=null && str.length()>0){
            return false;
        }else{
            return true;
        }
    }

    public static boolean checkEmptys(String... args){
        boolean r = false;

        for (String s:args) {
            r = checkEmpty(s);
            if (r) {
                break;
            }
        }
        return r;

    }
}
