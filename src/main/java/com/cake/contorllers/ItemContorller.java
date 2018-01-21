package com.cake.contorllers;

import com.cake.mapper.GoodMapper;
import com.cake.pojo.Good;
import com.cake.service.Impl.GoodServiceImpl;
import com.google.common.base.Optional;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        System.out.println("typeId = [" + typeId + "], modelAndView = [" + modelAndView + "]");
        return modelAndView;
    }
}
