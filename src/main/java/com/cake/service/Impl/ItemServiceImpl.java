package com.cake.service.Impl;

import com.cake.mapper.ItemMapper;
import com.cake.mapper.OrderMapper;
import com.cake.pojo.Item;
import com.cake.pojo.MiniCart;
import com.cake.service.inteerfaces.IItemService;
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
    private OrderMapper orderMapper;

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
