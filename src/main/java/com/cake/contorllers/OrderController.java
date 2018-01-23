package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.OrderServiceImpl;
import com.cake.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 获取页面的请求提交支付
     * @param userId
     * @return
     */
    @RequestMapping("/pay")
    public ModelAndView getOrderList(@RequestParam("userId")Integer userId){
        ModelAndView modelAndView = new ModelAndView();
        //调用根据用户id查询用户信息的方法
        User user = userService.getUserByUserId(userId);
        //生成订单号时间
        String orderDate = orderService.getOrderDate();
        //生成随机订单号
        Long orderNumber = orderService.getOrderNumber();

        //用户对象放入模型中
        modelAndView.addObject("user",user);
        //时间放入模型当中
        modelAndView.addObject("orderDate",orderDate);
        //设置跳转的页面至支付页面
        modelAndView.setViewName("index/pay");
        return modelAndView;
    }


}
