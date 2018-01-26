package com.cake.contorllers;

import com.cake.pojo.Item;
import com.cake.pojo.OrderManager;
import com.cake.service.Impl.ItemServiceImpl;
import com.cake.service.Impl.OrderServiceImpl;
import com.cake.uilt.Uilt;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "" ,method = RequestMethod.POST,produces = "text/jsp;charset=UTF-8")
public class AdminOrderContorller {
    @Autowired
    private ItemServiceImpl itemService;
    @Autowired
    private OrderServiceImpl orderService;

    /***
     * 后台订单管理，分页显示
     * @param pageIndex
     * @return
     */

    @PostMapping("/pageindex")
    @ResponseBody
    public String pageOerderlist(@RequestParam("pageindex")Integer pageIndex){
        List<OrderManager> orderManagers =
                itemService.orderManger(pageIndex);
        if (null==orderManagers){
            return "nodate";
        }
        return Uilt.getGsonToString(orderManagers);
    }

    /***
     * 订单发货方法
     * @param goodId
     * @return
     */
    @PostMapping("/goorder")
    @ResponseBody
    public String goOrder(@RequestParam("goid") Integer goodId){
        Optional.of(goodId);
        Item item = itemService.getItemByGoodId(goodId);
        Optional.of(item);
        int num=orderService.changeOrderStatus(item.getOrderId());
        if(num>0){
            return "ok";
        }else {
            return "no";
        }
    }
    @ResponseBody
    @PostMapping("/deleteorder")
    public String deleteOrder(@RequestParam("deleteorderid") Integer goodId){
        Optional.of(goodId);
        Item item = itemService.getItemByGoodId(goodId);
        Optional.of(item);
        int num =orderService.deleteOrder(item.getOrderId());
        return null;
    }
}
