package com.cake.service.Impl;

import com.cake.mapper.GoodMapper;
import com.cake.mapper.ItemMapper;
import com.cake.mapper.OrderMapper;
import com.cake.mapper.UserMapper;
import com.cake.pojo.*;
import com.cake.pojo.Item;
import com.cake.pojo.MiniCart;
import com.cake.service.inteerfaces.IItemService;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;


    /****
     * 查询所有item,级相关的order,user,goog,信息，并封装为
     * OrderManager 对象，存入集合中，返回该集合
     * @return
     */
    public List<OrderManager> orderManger(Integer pageindex) {
        if (null==pageindex){pageindex=0;}
        //获取数据库item的数量
        int itemCount= itemMapper.getCount();
        if (itemCount==0){
            return null;
        }
        //计算分页显示数据的起始下标
        Uilt.getPageNum(pageindex,itemCount);
        List<Item> itemList = itemMapper.seleItems(Uilt.startSize,Uilt.AdminpageSize);
        System.out.println(itemList);
        if (null==itemList){
            return null;
        }
        List<OrderManager> managerList = new ArrayList<OrderManager>();
        for (Item item : itemList){
            Good good = goodMapper.slectGoodByGoodId(item.getGoodId());
            Order order =orderMapper.selectByPrimaryKey(item.getOrderId());
            User user = userMapper.selectByPrimaryKey(order.getUserId());
            OrderManager orderManager = new OrderManager(good,item,user,order);
            managerList.add(orderManager);
        }
        return managerList;
    }

    /***
     * 重载分页查询方法,根据支付状态查询
     * @param status
     * @param pageindex
     * @return
     */
    public List<OrderManager> orderManger(Integer status, Integer pageindex){
        if (null==pageindex){pageindex=0;}
        int orderCount = orderMapper.searchCountByPayStatus(status);
        if (orderCount==0){
            return null;
        }
        System.out.println("222"+orderCount);
        Uilt.getPageNum(pageindex,orderCount);
        List<Item> itemList = itemMapper.selectItems();
        if (itemList==null){return null;}
        List<OrderManager> managerList = new ArrayList<OrderManager>();
        for (Item item : itemList){
             Order order = orderMapper.selectByPrimaryKey(item.getOrderId());
             if (order.getStatus().equals(status)){
                 Good good = goodMapper.slectGoodByGoodId(item.getGoodId());
                 User user = userMapper.selectByPrimaryKey(order.getUserId());
                 OrderManager orderManager = new OrderManager(good,item,user,order);
                 orderManager.setPageCount(Uilt.pageCount);
                 orderManager.setPageIndex(Uilt.pageIndex);
                 managerList.add(orderManager);
             }
        }
        return managerList;
    }
    /***
     * 根据商品id,返回item
     * @param goodid
     * @return
     */
    public Item getItemByGoodId(Integer goodid) {
        return itemMapper.selectByGoodId(goodid);
    }

    /***
     * 根据商品id 删除item
     * @param goodId
     * @return
     */
    public Integer deleteItem(Integer goodId) {
        return itemMapper.updateByPrimaryKey(goodId);
    }

    public Item selectByPrimaryKey(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    public List<Item> getAllItem() {
        return itemMapper.selectItems();
    }

    /****
     * 对李晶的代码修改，后增加方法
     * @param itemList
     * @param session
     */
    public void showOrder(List<Item> itemList,HttpSession session) {
         List<OrderManager> orderList = new ArrayList<OrderManager>();
        for (Item item : itemList){
            OrderManager orderManager = new OrderManager();
            Good good =goodMapper.slectGoodByGoodId(item.getGoodId());
            Order order = orderMapper.selectByPrimaryKey(item.getOrderId());
            orderManager.setGood(good);
            orderManager.setItem(item);
            orderManager.setOrder(order);
            orderList.add(orderManager);
        }
        session.setAttribute("orderList",orderList);
    }

    /****
     * item删除操作
     * @param id
     * @return
     */
    public int deteleItem(Integer id) {
        return itemMapper.deteleByPrimaryKey(id);
    }

    /**
     *  给数据库表格items表格添加数据
     * @param item item对象
     * @return 返回被影响的行数
     */
    public Integer insertItem(Item item) {
        Integer rollBack = itemMapper.insert(item);
        return rollBack;
    }

    /**
     * 对item进行组装存进数据库
     * @param httpSession
     * @return  item对象的集合
     */
    public List<Item> packagingItem(HttpSession httpSession) {
        //获取session中存放的MiniCart集合
        List<MiniCart> miniCartList = (List<MiniCart>) httpSession.getAttribute("minGoodsNum");
        List<Item> itemList = new ArrayList<Item>();
        for (MiniCart miniCart:
                miniCartList) {
            //创建item对象
            Item item = new Item();
            item.setAmount(miniCart.getCount());
            item.setGoodId(miniCart.getGood().getId());
            item.setPrice(miniCart.getGood().getPrice());
            item.setOrderId(orderMapper.searchMaxId());
            //将对象存进数据库
            itemMapper.insert(item);
            System.out.println("组装好的Item对象"+item.toString());
            //将对象放进集合当中
            itemList.add(item);
        }
        return itemList;
    }


}
