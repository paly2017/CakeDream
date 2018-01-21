package com.cake.contorllers;

import com.cake.pojo.Good;
import com.cake.service.Impl.GoodServiceImpl;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ItemContorller {
    @Autowired
    private GoodServiceImpl goodService;
    private Map<String,List<Good>> stringGoodMap;
    @RequestMapping("/typegoogs")
    public ModelAndView doGoodsPage(@RequestParam(value = "typeId")Integer typeId,
                                    ModelAndView modelAndView){
        Optional.of(typeId);
        stringGoodMap = goodService.getGoodList(typeId);
        String key =(String) stringGoodMap.keySet().toArray()[0];
        modelAndView.setViewName("index/goods");
        modelAndView.addObject("type",key);
        modelAndView.addObject("goods",stringGoodMap.get(key));
        modelAndView.addObject("size", stringGoodMap.get(key).size()/4+1);
        System.out.println("typeId = [" + typeId + "], modelAndView = [" + modelAndView + "]");
        return modelAndView;
    }
}
