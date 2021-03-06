package com.cake.contorllers;

import com.cake.pojo.Good;
import com.cake.pojo.Type;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import com.cake.uilt.Uilt;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class GoodContorller {

    @Autowired
    private GoodServiceImpl goodService;
    private Map<String,List<Good>> stringGoodMap;
    @Autowired
    private TypeServiceImpl typeService;

    @RequestMapping("/typegoogs")
    public ModelAndView doGoodsPage(@RequestParam(value = "typeId")Integer typeId,
                                    ModelAndView modelAndView, HttpServletRequest request){
        Optional.of(typeId);
        stringGoodMap = goodService.getGoodList(typeId);
        String key =(String) stringGoodMap.keySet().toArray()[0];
        Uilt.getPageNum(0,stringGoodMap.get(key).size());
        modelAndView.setViewName("index/goods");
        modelAndView.addObject("type",key);
        modelAndView.addObject("goods",stringGoodMap.get(key));
        modelAndView.addObject("size", Uilt.pageCount);
        modelAndView.addObject("index",1);
        request.getSession().setAttribute("typeid",typeId);
        request.getSession().setAttribute("pagecount",stringGoodMap.get(key).size());
        System.out.println("typeId = [" + typeId + "], modelAndView = [" + modelAndView + "]");
        return modelAndView;
    }

    /***
     * goods页面商品类型分页查询控制器
     * @param index
     * @param modelAndView
     * @return
     */
    @RequestMapping("/pageing")
    public ModelAndView doPageing(@RequestParam(value = "index") Integer index,
                                  ModelAndView modelAndView, HttpServletRequest request){
        Integer typeid =Integer.parseInt(request.getSession().getAttribute("typeid").toString());
        Integer pageCount = Integer.parseInt(request.getSession().getAttribute("pagecount").toString());
        Uilt.getPageNum(index,pageCount);
        List<Good> goodList =  goodService.getPageingGoods(typeid);
        modelAndView.addObject("goods",goodList);
        modelAndView.addObject("size", Uilt.pageCount);
        modelAndView.addObject("index",Uilt.pageIndex);
        modelAndView.setViewName("index/goods");
        return modelAndView;
    }

    /**
     * 根据商品ID查询商品
     * @param goodID 从页面获取到的商品ID
     * @return 返回商品详情页面显示单品
     */
    @RequestMapping("/detail")
    public ModelAndView getGoodById(@RequestParam("goodId")Integer goodID,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (null==session.getAttribute("alltype")){
             typeService.selectAllType(request);
        }
        //创建视图模型对象
        ModelAndView modelAndView = new ModelAndView();
        //通过方法创建新的商品对象
        Good good = goodService.getGoodById(goodID);
        Integer typeId = good.getTypeId();
        //获取蛋糕系列对象
        Type type = typeService.findTypeByTypeId(typeId);
        //将商品放进视图模型中
        modelAndView.addObject("goodDetail",good);
        modelAndView.addObject("typeDetail",type);
        //设置页面跳转地址
        modelAndView.setViewName("index/detail");
        //返回视图模型
        return modelAndView;
    }




}
