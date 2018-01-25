package com.cake.mapper;


import com.cake.pojo.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    //给数据库items表格插入数据
    @Insert("INSERT INTO items(price, amount, order_id, good_id) VALUES" +
            " (#{price},#{amount},#{orderId},#{goodId});")
    int insert(Item item);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
    @Select(value = "SELECT * FROM items WHERE 1=1 ORDER BY id ;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "price",column = "price"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodId",column = "good_id")
    })
    List<Item> seleItems();
}