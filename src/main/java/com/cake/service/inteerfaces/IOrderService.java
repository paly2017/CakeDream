package com.cake.service.inteerfaces;

import com.cake.pojo.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IOrderService {

    //生成一个下单时间
    String getOrderDate();
    //生成一个随机订单号
    String getOrderNumber();
    /**
     *
     * @param payType   支付方法
     * @return
     */
    //组装order对象 需要传参
    void insertOrder(HttpSession httpSession,Integer payType );


    //获取订单的总价，支付时间、订单编号
    void getOrderListFunction(HttpSession httpSession);

    /**
     * 获取orders表格中的最大id
     * @return
     */
    Integer getMaxOrdersId();

    /**
     * 从session中获取购物车信息，进行对order对象属性进行封装
     * @param httpSession
     * @param payType  支付方法
     * @return  一个组装好的order对象
     */
    List<Item> packagingOrder(HttpSession httpSession, Integer payType);

    int changeOrderStatus(Integer orderId);

    /****
     * 根据支付类型获取订单
     * @param paytype
     * @return
     */
    List<Order> getOrderByPayType(Integer paytype);

    /****
     * 订单删除方法
     * @param item
     * @return
     */
    boolean deteleOrder(Item item);



}
