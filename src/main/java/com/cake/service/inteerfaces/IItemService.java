package com.cake.service.inteerfaces;

import com.cake.pojo.Item;

import javax.servlet.http.HttpSession;
import java.util.List;

import com.cake.pojo.OrderManager;

import java.util.List;

public interface IItemService {
    //数据库给items表格添加数据
    Integer insertItem(Item item);

    //组装I特么
    List<Item> packagingItem(HttpSession httpSession);


    /****
     * 订单分页查询
     * @param pageIndex
     * @return
     */
    List<OrderManager> orderManger(Integer pageIndex);

    /***
     * 根据goodid返回item
     * @param goodid
     * @return
     */
    Item getItemByGoodId(Integer goodid);

    /***
     * 根据商品删除购买记录
     * @param goodId
     * @return
     */
    Integer deleteItem(Integer goodId);


    Item selectByPrimaryKey(Integer id);

    /****
     * 获取全部item
     * @return
     */
    List<Item> getAllItem();
}
