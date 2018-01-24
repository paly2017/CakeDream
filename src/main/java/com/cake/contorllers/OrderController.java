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
     * 购物车提交订单页面controller
     * @return 跳转至支付页面
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

    @RequestMapping("/payOk")
    public String jumpToOrderPayOk(HttpServletRequest httpServletRequest,@RequestParam("payType")Integer payType){
        HttpSession httpSession = httpServletRequest.getSession();
        //调用方法 获取一个order对象的集合
        List<Order> orderList = orderService.insertOrder(httpSession,payType);
        //获取数据库orders表中的最大id
        Integer maxOrdersId = orderService.getMaxOrdersId();
        httpSession.setAttribute("maxOrderId",maxOrdersId);
        //将集合放入session中
        httpSession.setAttribute("orderList",orderList);
        //System.out.println("获取到的order最大的id："+maxOrdersId);
        return "index/payok";
    }
    //从支付成功页面跳转至order.jsp页面
    @RequestMapping("/order")
    public String jumpToOrder(){

      /*  List<Order> orderList = (List<Order>) httpSession.getAttribute("orderList");*/
        //System.out.print("获取session中的order对象是："+order.toString());
        return "index/order";
    }

}
