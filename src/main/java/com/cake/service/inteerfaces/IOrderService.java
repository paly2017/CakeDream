package com.cake.service.inteerfaces;

import com.cake.pojo.MiniCart;
import com.cake.pojo.Order;
import com.cake.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IOrderService {

    //生成一个下单时间
    String getOrderDate();
    //生成一个随机订单号
    long getOrderNumber();



    /**
     *
     * @param payType   支付方法
     * @return
     */
    //组装order对象 需要传参
    List<Order> insertOrder(HttpSession httpSession,Integer payType );


    //获取订单的总价，支付时间、订单编号
    HttpSession getOrderListFunction(HttpSession httpSession);

    /**
     * 获取orders表格中的最大id
     * @return
     */
    Integer getMaxOrdersId();

}
