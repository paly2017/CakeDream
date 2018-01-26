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

import java.util.ArrayList;
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
        List<OrderManager> orderManagers1 = new ArrayList<OrderManager>();
        for (OrderManager orderManager: orderManagers){
            if (orderManager.getOrder().getDelete()==1){
                orderManagers1.add(orderManager);
            }
        }
        modelAndView.addObject("adminorder",orderManagers1);
        modelAndView.addObject("pagecount",Uilt.pageCount);
        modelAndView.addObject("pageindex",Uilt.pageIndex);
        return modelAndView;
    }
}
