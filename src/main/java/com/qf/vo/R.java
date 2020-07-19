package com.qf.vo;

import lombok.Data;


public class R<T> {
    private int code;
    private String msg;
    private T data;

    //封装方法
    public R(){}
    public R(int code,String msg,T obj){
        this.code=code;
        this.msg=msg;
        this.data=obj;
    }
    //成功
    public static <E> R ok(Object obj){
        return new R(200,"OK", obj);
    }
    //返回 成功無參數
    public static <E> R ok(){
        return new R(200,"OK",null);
    }
    //失败
    public static <E> R error(String msg){
        return new R(400,msg,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
