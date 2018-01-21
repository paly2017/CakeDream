package com.cake.contorllers;

import com.cake.pojo.Good;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.uilt.Uilt;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ItemContorller {
    @Autowired
    private GoodServiceImpl goodService;
    private Map<String,List<Good>> stringGoodMap;
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
        System.out.println("index = [" + index + "], pageIndex = [" + Uilt.pageIndex + "], request = [" + pageCount+"]");
        return modelAndView;
    }
}
