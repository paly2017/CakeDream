package com.cake.uilt;

import com.cake.pojo.Good;
import com.cake.pojo.Top;
import com.cake.pojo.Type;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class Uilt{
    public static Integer pageCount;
    public static final Integer pageSize = 4;
    public static final Integer AdminpageSize = 10;
    public static Integer startSize ;
    public static Integer pageIndex;
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
     * pagecount 总的数据条数
     * index 页面下标
     * @param  index
     * @param  pagecount
     */
   public static void getPageNum(Integer index,Integer pagecount){
       pageCount = pagecount%pageSize==0?pagecount/pageSize:pagecount/pageSize+1;
       pageIndex=index;
       if (index<=0){
           pageIndex=1;
       }
       if (index>=pageCount){
           pageIndex = pageCount ;
       }
       startSize = (pageIndex-1)*pageSize<=0?0:(pageIndex-1)*pageSize;

   }

}
