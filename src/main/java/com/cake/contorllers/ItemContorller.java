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

/******
 * 后台商品管理
 */
@Controller
public class ItemContorller {
    @Autowired
    private ItemServiceImpl itemService;
    @RequestMapping("/orderlist")
    public ModelAndView showItems(ModelAndView modelAndView){
        List<OrderManager> orderManagers =
                                itemService.orderManger(0);
        modelAndView.setViewName("admin/order_list");
        if (null==orderManagers){
           return modelAndView;
        }
        modelAndView.addObject("adminorder",orderManagers);
        modelAndView.addObject("pagecount",Uilt.pageCount);
        modelAndView.addObject("pageindex",Uilt.pageIndex);
        return modelAndView;
    }
    @RequestMapping("/pageIndex")
    public ModelAndView showItems(ModelAndView modelAndView,
                                  @RequestParam("pageindex") Integer index){
        List<OrderManager> orderManagers =
                itemService.orderManger(index);
        modelAndView.setViewName("admin/order_list");
        if (null==orderManagers){
            return modelAndView;
        }
        modelAndView.addObject("adminorder",orderManagers);
        modelAndView.addObject("pagecount",Uilt.pageCount);
        modelAndView.addObject("pageindex",Uilt.pageIndex);
        return modelAndView;
    }

    /********以上商品管理不分类型********/
    /****
     * 根据支付类型查询商品
     * @param modelAndView
     * @param status
     * @return
     */
    @RequestMapping("/showOrderInfo")
    public ModelAndView showOrderInfo(ModelAndView modelAndView,
                                      @RequestParam("statusorder")Integer status){
        System.out.println("modelAndView = [" + modelAndView + "], status = [" + status + "]");
        List<OrderManager> orderManagers =
                itemService.orderManger(status,0);
        int count = 0;
        modelAndView.setViewName("admin/order_list");
        if (orderManagers==null){
            return modelAndView;
        }
        List<OrderManager> orderManagerList= new ArrayList<OrderManager>();
        for (OrderManager orderManager :orderManagers){
            ++count;
            System.out.println("333"+Uilt.pageCount);
            if (0<=count&&count<=Uilt.AdminpageSize){
                orderManagerList.add(orderManager);
            }
        }
        if (null==orderManagerList){
            return modelAndView;
        }
        modelAndView.addObject("adminorder",orderManagerList);
        modelAndView.addObject("pagecount",Uilt.pageCount);
        modelAndView.addObject("pageindex",Uilt.pageIndex);
        return modelAndView;
    }


    @RequestMapping("/pageIndexStatus")
    public ModelAndView showItems(ModelAndView modelAndView,
                                  @RequestParam("pageindex") Integer index,
                                  @RequestParam("status")Integer status){
        System.out.println("laile");
        List<OrderManager> orderManagers =
                itemService.orderManger(index);
        System.out.println(orderManagers);
        modelAndView.setViewName("admin/order_list");
        if (null==orderManagers){
            return modelAndView;
        }
        List<OrderManager> managerList = new ArrayList<OrderManager>();
        for (OrderManager orderManager : orderManagers){
            if (orderManager.getOrder().getStatus()==status){
                managerList.add(orderManager);
            }
        }
        modelAndView.addObject("adminorder",managerList);
        modelAndView.addObject("pagecount",Uilt.pageCount);
        modelAndView.addObject("pageindex",Uilt.pageIndex);
        return modelAndView;
    }
}
