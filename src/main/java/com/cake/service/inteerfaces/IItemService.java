package com.cake.service.inteerfaces;

import com.cake.pojo.Item;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IItemService {
    //数据库给items表格添加数据
    Integer insertItem(Item item);

    //组装I特么
    List<Item> packagingItem(HttpSession httpSession);


}
