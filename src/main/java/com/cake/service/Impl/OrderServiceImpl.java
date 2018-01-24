package com.cake.service.Impl;

import com.cake.mapper.OrderMapper;
import com.cake.pojo.MiniCart;
import com.cake.pojo.Order;
import com.cake.pojo.User;
import com.cake.service.inteerfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 生成订单时间
 * 返回一个时间
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
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

    //组装order对象
    public Order insertOrder(User user, Long orderNumber, Integer allAmount, Integer goodNums, String orderDate,Integer payType) {
        //创建order对象
        Order order = new Order();
        //对order对象属性进行组装
        order.setTotal(allAmount);
        Timestamp timestamp = Timestamp.valueOf(orderDate);
        order.setSystime(timestamp);//时间类型转换 String转换为Timestamp
        order.setAmount(goodNums);
        order.setPhone(user.getPhone());
        order.setName(user.getName());
        order.setUserId(user.getId());
        order.setAddress(user.getAddress());
        order.setPaytype(payType);//支付方法
        order.setStatus(2);
        //将对象放入数据库
        orderMapper.insert(order);
        return order;
    }

    //对order数据对象进行获取并且封装值session当中
    public HttpSession getOrderListFunction(HttpSession httpSession, User user) {
        //获取购物车商品集合
        List<MiniCart> miniCartList = (List<MiniCart>) httpSession.getAttribute("minGoodsNum");
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

        //生成订单号时间
        String orderDate = this.getOrderDate();
        //生成随机订单号
        Long orderNumber = this.getOrderNumber();

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
        return httpSession;
    }


}
