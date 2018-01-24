package com.cake.contorllers;

import com.cake.pojo.MiniCart;
import com.cake.pojo.Order;
import com.cake.pojo.User;
import com.cake.service.Impl.OrderServiceImpl;
import com.cake.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

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
    public String getOrderList(@RequestParam("userId")Integer userId,
                               HttpSession httpSession   ){
        //调用根据用户id查询用户信息的方法
        User user = userService.getUserByUserId(userId);
        orderService.getOrderListFunction(httpSession,user);
        //设置跳转的页面至支付页面
        return "index/pay";
    }

    @RequestMapping("/payOk")
    public String jumpToOrderPayOk(HttpSession httpSession,@RequestParam("payType")Integer payType){

        //从session中获取相应的信息
        User user = (User) httpSession.getAttribute("user");//用户
        Long orderNumber = (Long) httpSession.getAttribute("orderNumber"); //订单号
        Integer allAmount = (Integer) httpSession.getAttribute("allAmount"); //商品总价
        Integer goodNums = (Integer) httpSession.getAttribute("goodNums");//商品总数
        String orderDate = (String) httpSession.getAttribute("orderDate"); //生成订单号时间
        //调用方法
        Order order = orderService.insertOrder(user,orderNumber,allAmount,goodNums,orderDate,payType);
        httpSession.setAttribute("order",order);
        return "index/payok";
    }




}
