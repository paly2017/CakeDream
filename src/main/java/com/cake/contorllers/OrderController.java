package com.cake.contorllers;

import com.cake.pojo.MiniCart;
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
                                     HttpServletRequest request  ){
        HttpSession httpSession = request.getSession();
        //获取购物车商品集合
        List<MiniCart> miniCartList = (List<MiniCart>) request.getSession().getAttribute("minGoodsNum");
       //循环遍历集合 获取商品数量和总价
        Integer allAmount = 0;
        Integer goodNums = 0;
        for (MiniCart miniCart:
             miniCartList) {
            goodNums = goodNums+miniCart.getCount();
            //单个商品总价
           Integer amount =  (miniCart.getGood().getPrice())*(miniCart.getCount());
            //所有商品总价
            allAmount=amount+allAmount;
        }


        //调用根据用户id查询用户信息的方法
        User user = userService.getUserByUserId(userId);
        //生成订单号时间
        String orderDate = orderService.getOrderDate();
        //生成随机订单号
        Long orderNumber = orderService.getOrderNumber();


        //订单号放入session
        httpSession.setAttribute("orderNumber",orderNumber);
        //用户对象放入session
        httpSession.setAttribute("user",user);
        //商品总价放入session
        httpSession.setAttribute("allAmount",allAmount);
        //商品总数放入session
        httpSession.setAttribute("goodNums",goodNums);
        //时间放入模型当中
        httpSession.setAttribute("orderDate",orderDate);
        //设置跳转的页面至支付页面
        return "index/pay";
    }


}
