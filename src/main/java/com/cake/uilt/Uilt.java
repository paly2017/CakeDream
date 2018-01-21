package com.cake.uilt;

import com.google.gson.Gson;
import org.springframework.web.servlet.HttpServletBean;


public class Uilt{

    private static  Gson gson;
    //实例化一个Gson对象
    static {
        if (gson==null){
            gson = new Gson();
        }
    }

    /***
     * 获取json字符串
     * @param object
     * @return
     */
    public static String getGsonToString(Object object){
        if(null==object){
            return "";
        }
        return  gson.toJson(object);
    }

    public static String getPage(HttpServletBean httpServletBean){

        return null;
    }
}
