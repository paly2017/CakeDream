package com.cake.contorllers;

import com.cake.pojo.Good;
import com.cake.pojo.Top;
import com.cake.pojo.Type;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TopServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import com.cake.uilt.Uilt;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//首页控制--首页根据商品推荐类型显示
@Controller
public class TopControl {
    //service实现类作为属性注入
    @Autowired
    private TopServiceImpl topServiceImpl;

    @RequestMapping("/index")
    public ModelAndView selectIndexGoods(ModelAndView modelAndView){
        //调用service曾的方法，获得首页展示商品的集合
        //精品推荐
        List<Top> jingPin =topServiceImpl.selectTopListByType(1);
        //热销推荐
        List<Top> hotGood =topServiceImpl.selectTopListByType(2);
        //新品推荐
        List<Top> newGood =topServiceImpl.selectTopListByType(3);
        modelAndView.addObject("jingPinList",jingPin);
        modelAndView.addObject("hotGoodList",hotGood);
        modelAndView.addObject("newGoodList",newGood);
        modelAndView.setViewName("index/index");
        return modelAndView;
    }

    //获得热销、新品推荐的商品
    @RequestMapping("/tops")
    public ModelAndView selectHotGoods(@RequestParam(value ="type",required = false)Integer type,
                                        @RequestParam(value ="pageNum",required = false)Integer pageNum,//当前页数
                                       @RequestParam(value ="admin",required = false)Integer admin,//参数--判断是哪个请求，跳到哪个学校页面
                                       ModelAndView modelAndView,
                                       HttpServletRequest request){
        //根据传入的type查询--先查出总共多少条
        List<Top> AllList =topServiceImpl.selectTopListByType(type);
       //总共多少条数据
        Integer sum =AllList.size();
        //页面容量
        Integer pageSize=4;
        //总共多少页
        Integer pageCount =sum%4==0?sum/4:sum/4+1;
        //判断当前页数是否为0
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<=0){
            pageNum=1;
        }else if(pageNum>pageCount){
            pageNum=pageCount;
        }
        Integer fromIndex =pageSize*(pageNum-1);
        //判断
        //分页查询，得到分页查询的集合
        List<Top> limit =topServiceImpl.selectByLimit(type,fromIndex,pageSize);
        Integer flag=2;//遍历Top
        request.getSession().setAttribute("good",flag);
        //将数据和页面放入ModelAndView
        modelAndView.addObject("limitList",limit);
        //将页数也要放入ModelAndView
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("pageCount",pageCount);
        if(admin==1){
            modelAndView.setViewName("index/top");
        }else{
            modelAndView.setViewName("admin/good_list");
        }
        return modelAndView;
    }



}
