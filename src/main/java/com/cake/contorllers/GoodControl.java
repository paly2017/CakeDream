package com.cake.contorllers;

import com.cake.pojo.Good;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TopServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GoodControl {
    @Autowired
   private GoodServiceImpl goodServiceImpl;
    @Autowired
    private TopServiceImpl topServiceImpl;
    @Autowired
    private TypeServiceImpl typeServiceImpl;
    //查出所有商品推荐显示在所有商品页面
    @RequestMapping("/allGood")
    public ModelAndView selectAllGood(@RequestParam(value ="pageNum",required = false)Integer pageNum,
                                     ModelAndView modelAndView,
                                     HttpServletRequest request){
        //查出商品总数
       List<Good> all =goodServiceImpl.selectAllGood();
       Integer sum=all.size();
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
        //分页查询
        Integer flag=1;//遍历Good
        request.getSession().setAttribute("good",flag);
        List<Good> limitList= goodServiceImpl.selectLimitGood(fromIndex,pageSize);
        //循环遍历集合--查商品推荐、商品类型
        for (Good good:limitList) {
          /*  good.setTop(topServiceImpl.selectTopByGoodId(good.getId()));*/
            good.setType(typeServiceImpl.selectTpyeById(good.getTypeId()));
        }
        modelAndView.addObject("goodList",limitList);
        //将页数也要放入ModelAndView
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("pageCount",pageCount);
        modelAndView.setViewName("admin/good_list");
        return modelAndView;
    }
/**
 * 通过商品id，更改商品的推荐属性，1、条幅  2、热销  3、新品
 */
    //移出条幅
    //移出热销
    //移除新品
    public ModelAndView removeTops(Integer id,
                                    ModelAndView modelAndView){
        topServiceImpl.removeTops(id);
        return modelAndView;
    }
    //加入条幅
    //加入热销
    //加入新品
}
