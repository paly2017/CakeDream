package com.cake.uilt;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;



public class Uilt {
    @Autowired
    private static  Gson gson;
    static {
        if (gson==null){
            gson = new Gson();
        }
    }

    public static String getGsonToString(Object object){
        return  gson.toJson(object);
    }

}
