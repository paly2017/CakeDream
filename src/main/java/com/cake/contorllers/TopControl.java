package com.cake.contorllers;

import com.cake.pojo.Good;
import com.cake.pojo.Top;
import com.cake.pojo.Type;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TopServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired
    private GoodServiceImpl goodServiceImpl;
    @Autowired
    private TypeServiceImpl typeServiceImpl;
    @RequestMapping("/index")
    public ModelAndView selectIndexGoods(ModelAndView modelAndView){
        //调用service曾的方法，获得首页展示商品的集合
        //精品推荐
        List<Top> jingPinList =topServiceImpl.selectTopListByType(1);
        //热销推荐
        List<Top> hotGoodList =topServiceImpl.selectTopListByType(2);
        //新品推荐
        List<Top> newGoodList =topServiceImpl.selectTopListByType(3);

        //循环便利精品推荐，获得商品放入Top
        for (Top top:jingPinList) {
            //查出来一个商品
            Good good =goodServiceImpl.slectGoodByGoodId(top.getGoodId());
            //根据商品的type_id查出来一个Type
            Type type=typeServiceImpl.selectTpyeById(good.getTypeId());
            top.setGood(good);
            top.setGoodType(type);
        }
        for (Top top:hotGoodList) {
            //查出来一个商品
            Good good =goodServiceImpl.slectGoodByGoodId(top.getGoodId());
            //根据商品的type_id查出来一个Type
            Type type=typeServiceImpl.selectTpyeById(good.getTypeId());
            top.setGood(good);
            top.setGoodType(type);
        }


        for (Top top:newGoodList) {
            //查出来一个商品
            Good good =goodServiceImpl.slectGoodByGoodId(top.getGoodId());
            //根据商品的type_id查出来一个Type
            Type type=typeServiceImpl.selectTpyeById(good.getTypeId());
            top.setGood(good);
            top.setGoodType(type);
        }
        modelAndView.addObject("jingPinList",jingPinList);
        modelAndView.addObject("hotGoodList",hotGoodList);
        modelAndView.addObject("newGoodList",newGoodList);
        modelAndView.setViewName("index/index");
        return modelAndView;
    }
}
