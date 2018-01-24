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
import java.util.ArrayList;
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

    //组装order对象,返回一个带有order对象的集合
    public   List<Order> insertOrder(HttpSession httpSession,Integer payType) {
        //获取session中存放的MiniCart集合
        List<MiniCart> miniCartList = (List<MiniCart>) httpSession.getAttribute("minGoodsNum");
        User user = (User) httpSession.getAttribute("loginUser");
        //从session中获取相应的信息
        Long orderNumber = (Long) httpSession.getAttribute("orderNumber"); //订单号
        Integer allAmount = (Integer) httpSession.getAttribute("allAmount"); //商品总价
        String orderDate = (String) httpSession.getAttribute("orderDate"); //生成订单号时间
        List<Order> orderList =  new ArrayList<Order>();
        for (MiniCart miniCart:
             miniCartList) {
            //创建order对象
            Order order = new Order();
            //对order对象属性进行组装
            order.setTotal(miniCart.getCount()*miniCart.getGood().getPrice());//单个商品总价
            Timestamp timestamp = Timestamp.valueOf(orderDate);
            order.setSystime(timestamp);//时间类型转换 String转换为Timestamp
            order.setAmount(miniCart.getCount());// 单件商品数量
            order.setPhone(user.getPhone());//收货人电话
            order.setName(user.getName());//收货人姓名
            order.setUserId(user.getId());//用户id
            order.setAddress(user.getAddress());//收货地址
            order.setPaytype(payType);//支付方法
            order.setStatus(2);
            //将对象放入数据库
            orderMapper.insert(order);
            //查询最大id
            order.setId(orderMapper.searchMaxId());
            //将对象添加进入集合
            orderList.add(order);
        }
        return orderList;//返回order对象集合
    }


    //获取订单的总价，支付时间、订单编号
    public void getOrderListFunction(HttpSession httpSession) {
        //获取购物车商品集合
        List<MiniCart> miniCartList = (List<MiniCart>) httpSession.getAttribute("minGoodsNum");
     /*   User user = (User) httpSession.getAttribute("loginUser");*/
        //循环遍历集合 获取商品数量和总价
        Integer allAmount = 0;
        Integer goodNums = 0;
        Integer amount = 0;
        for (MiniCart miniCart:
                miniCartList) {
            //获取单个商品总数
            goodNums = goodNums+miniCart.getCount();
            //单个商品总价
            amount =  (miniCart.getGood().getPrice())*(miniCart.getCount());
            //所有商品总价
            allAmount=amount+allAmount;
        }
        //生成订单号时间
        String orderDate = this.getOrderDate();
        //生成随机订单号
        Long orderNumber = this.getOrderNumber();

        //订单号放入session
        httpSession.setAttribute("orderNumber",orderNumber);
        //所有商品总价放入session
        httpSession.setAttribute("allAmount",allAmount);
        //时间放入模型当中
        httpSession.setAttribute("orderDate",orderDate);
       /* //将用户对象放进session当中
        httpSession.setAttribute("user",user);*/

    }

    /**
     * 获取订单最大id
     * @return
     */
    public Integer getMaxOrdersId() {

        Integer maxId = orderMapper.searchMaxId();
        return maxId;
    }





}
