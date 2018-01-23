package com.cake.service.inteerfaces;

public interface IOrderService {

    //生成一个下单时间
    String getOrderDate();
    //生成一个随机订单号
    long getOrderNumber();

}
