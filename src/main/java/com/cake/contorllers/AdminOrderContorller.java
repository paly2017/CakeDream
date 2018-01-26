package com.cake.contorllers;

import com.cake.pojo.OrderManager;
import com.cake.service.Impl.ItemServiceImpl;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "" ,method = RequestMethod.POST,produces = "text/jsp;charset=UTF-8")
public class AdminOrderContorller {
    @Autowired
    private ItemServiceImpl itemService;

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
}
