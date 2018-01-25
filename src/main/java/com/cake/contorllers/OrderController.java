package com.cake.contorllers;

import com.cake.pojo.*;
import com.cake.service.Impl.ItemServiceImpl;
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
    @Autowired
    private ItemServiceImpl itemService;

    /**
     * 购物车提交订单页面controller
     * @return 跳转至支付页面
     * @author Philip
     */
    @RequestMapping("/pay")
    public String getOrderList(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute("loginUser");
        if (null==user){
            return "index/login";
        }
        orderService.getOrderListFunction(httpSession);
        //设置跳转的页面至支付页面
        return "index/pay";
    }
//从支付页面跳转至页面成功，准备显示订单详情
    @RequestMapping("/payOk")
    public String jumpToOrderPayOk(HttpServletRequest httpServletRequest,@RequestParam("payType")Integer payType){
        HttpSession httpSession = httpServletRequest.getSession();
        //调用方法 获取一个order对象的集合
       orderService.insertOrder(httpSession,payType);
       System.out.println("订单信息插入数据库成功");
       //清空购物车session
        //httpSession.removeAttribute("minGoodsNum");
        return "index/payok";
    }

    //从支付成功页面跳转至order.jsp页面
    @RequestMapping("/order")
    public String jumpToOrder(HttpServletRequest httpServletRequest){
             HttpSession httpSession =
                             httpSession = httpServletRequest .getSession();
            //session当中获取所需集合
            List<Order> orderList = (List<Order>) httpSession.getAttribute("orderList");
            List<Item> itemList = (List<Item>)httpSession.getAttribute("itemList");
            List<Good> goodList =(List<Good>) httpSession.getAttribute("goodList");
            System.out.println("即将跳转至订单详情页面");
            //集合仿佛session当中
            httpSession.setAttribute("orderList",orderList);
            httpSession.setAttribute("itemList",itemList);
            httpSession.setAttribute("goodList",goodList);

        //System.out.print("获取session中的order对象是："+order.toString());
            return "index/order";

    }

}
