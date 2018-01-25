package com.cake.contorllers;

import com.cake.pojo.OrderManager;
import com.cake.service.Impl.ItemServiceImpl;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemContorller {
    @Autowired
    private ItemServiceImpl itemService;
    @RequestMapping("/orderlist")
    public ModelAndView showItems(ModelAndView modelAndView,
                                    @RequestParam("index") Integer index){
        List<OrderManager> orderManagers =
                                itemService.orderManger(index);
        System.out.println(orderManagers);
        modelAndView.setViewName("admin/order_list");
        if (null==orderManagers){
           return modelAndView;
        }
        modelAndView.addObject("adminorder",orderManagers);
        return modelAndView;
    }
}
