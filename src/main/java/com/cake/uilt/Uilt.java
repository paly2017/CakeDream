package com.cake.uilt;

import com.google.gson.Gson;



public class Uilt{
    //需要显示的条数
    public static Integer pageSize=4;
    //总页码
    public static Integer pageCount;
    //当前页码
    public static Integer pageNow;
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

    /***
     * 分页处理工具，获得分页的总页码，分页当前页码
     * @param index
     */
   public static void getPageNum(Integer index,Integer dataSize){
       if (null==index){
           index = 0;
       }
       pageCount = dataSize%pageSize==0?dataSize/pageSize:(dataSize/pageSize)+1;
       pageNow = index*pageSize+1>pageCount?pageCount:index*pageSize+1;
   }
}
