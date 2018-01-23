package com.cake.service.Impl;

import com.cake.service.inteerfaces.IOrderService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成订单时间
 * 返回一个时间
 */
@Service
public class OrderServiceImpl implements IOrderService {
    public String getOrderDate() {
        //创建时间对象
        Date date = new Date();
        //设置时间格式
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取到当前时间
        String orderDate = simpleDateFormat.format(date);
        //返回当前时间
        return orderDate;
    }

    //生成随机订单号
    public long getOrderNumber() {
        //调用方法获取一个当前时间毫秒数的long型数字
        long orderNumber =  System.currentTimeMillis();
        return orderNumber;
    }
}
