package com.qf.util;

import java.util.UUID;

/**
 * @program: voter
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-13 18:08
 */
public class TokenUtil {
    public static String createToken(int uid){
        return UUID.randomUUID().toString().replaceAll("-","")+"_"+uid;
    }
}
