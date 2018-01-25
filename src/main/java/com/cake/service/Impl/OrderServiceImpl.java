package com.cake.service.Impl;

import com.cake.mapper.OrderMapper;
import com.cake.pojo.*;
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
    @Autowired
    private GoodServiceImpl goodService;
    @Autowired
    private ItemServiceImpl itemService;

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

    /**
     * 生成随机订单号
     * @author Philip
     * @return
     */
    public String getOrderNumber() {
        //调用方法获取一个当前时间毫秒数的long型数字
        long orderNum =  System.currentTimeMillis();
        //将long类型的订单编号修改为字符串类型
        String orderNumber =  Long.toString(orderNum);
        return orderNumber;
    }



    /**
     * 组装order、item、good对象,将所有对象的集合放入session当中
     * @param httpSession
     * @param payType   支付方法
     * @author Philip
     */
    public void insertOrder(HttpSession httpSession,Integer payType) {
        //获取Order       item      good对象的集合
        List<Order> orderList =  this.packagingOrder(httpSession,payType);
        //System.out.println("获取到的order集合"+orderList.toString());
        List<Item> itemList = itemService.packagingItem(httpSession);
        //System.out.println("获取到的item集合"+itemList.toString());
        List<Good> goodList = goodService.packagingGood(httpSession);
        //System.out.println("获取到的good集合"+goodList.toString());

        //将item     order       good集合放入session中
        httpSession.setAttribute("itemList",itemList);
        httpSession.setAttribute("orderList",orderList);
        httpSession.setAttribute("goodList",goodList);
    }


    //获取订单的总价，支付时间、订单编号
    public void getOrderListFunction(HttpSession httpSession) {
        //获取购物车商品集合
        List<MiniCart> miniCartList = (List<MiniCart>) httpSession.getAttribute("minGoodsNum");
        /*   User user = (User) httpSession.getAttribute("loginUser");*/
        //循环遍历集合 获取商品总价
        Integer allAmount = 0;
        for (MiniCart miniCart:
                miniCartList) {
            //单个商品总价
            allAmount =  (miniCart.getGood().getPrice())*(miniCart.getCount());
            //所有商品总价
            allAmount+=allAmount;
        }
        //生成订单号时间
        String orderDate = this.getOrderDate();
        //生成随机订单号
        String orderNumber = this.getOrderNumber();

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
     * @author Philip
     */
    public Integer getMaxOrdersId() {

        Integer maxId = orderMapper.searchMaxId();
        return maxId;
    }


    //组装order对象
    public List<Order> packagingOrder(HttpSession httpSession, Integer payType) {
        //获取session中存放的MiniCart集合
        List<MiniCart> miniCartList = (List<MiniCart>) httpSession.getAttribute("minGoodsNum");
        //System.out.println("获取到的购物车集合"+miniCartList.toString());
        User user = (User) httpSession.getAttribute("loginUser");
        //System.out.println("获取到的用户登录信息"+user.toString());
        //从session中获取相应的信息
        String orderNumber = (String) httpSession.getAttribute("orderNumber"); //订单号
        String orderDate = (String) httpSession.getAttribute("orderDate"); //生成订单号时间
        List<Order> orderList =  new ArrayList<Order>();
        for (MiniCart miniCart:
                miniCartList) {
            //创建order对象
            Order order = new Order();
            /******************* 对order对象进行组装********************/
            order.setTotal((miniCart.getCount()) * (miniCart.getGood().getPrice()));//单个商品总价
            Timestamp timestamp = Timestamp.valueOf(orderDate);
            order.setSystime(timestamp);//时间类型转换 String转换为Timestamp
            order.setAmount(miniCart.getCount());// 单件商品数量
            order.setPhone(user.getPhone());//收货人电话
            order.setName(user.getName());//收货人姓名
            order.setUserId(user.getId());//用户id
            order.setAddress(user.getAddress());//收货地址
            order.setPaytype(payType);//支付方法
            order.setStatus(2);//订单状态
            order.setOrderNo(orderNumber);//订单编号
            //将对象放入数据库
            Integer rollBack = orderMapper.insert(order);
            //System.out.println("插入order表格被影响的行数是"+rollBack);
            //查询最大id
            order.setId(orderMapper.searchMaxId());
            orderList.add(order);
        }
        return orderList;
    }


}
