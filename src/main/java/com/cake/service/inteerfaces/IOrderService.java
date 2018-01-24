package com.cake.service.inteerfaces;

import com.cake.pojo.Order;
import com.cake.pojo.User;

import javax.servlet.http.HttpSession;

public interface IOrderService {

    //生成一个下单时间
    String getOrderDate();
    //生成一个随机订单号
    long getOrderNumber();

    //组装order对象
    Order insertOrder(User user, Long orderNumber, Integer allAmount, Integer goodNums, String orderDate,Integer payType );

    HttpSession getOrderListFunction(HttpSession httpSession, User user);

}
