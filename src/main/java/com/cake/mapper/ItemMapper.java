package com.cake.mapper;


import com.cake.pojo.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ItemMapper {
    @Update("UPDATE items SET order_id=0 WHERE good_id=#{goodID};")
    int updateByPrimaryKey(@Param("goodID") Integer goodID);

    //给数据库items表格插入数据
    @Insert("INSERT INTO items(price, amount, order_id, good_id) VALUES" +
            " (#{price},#{amount},#{orderId},#{goodId});")
    int insert(Item item);

    int insertSelective(Item record);
    @Select(value = "SELECT *  FROM items WHERE id=#{id} AND order_id>0 ;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "price",column = "price"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodId",column = "good_id")
    })
    Item selectByPrimaryKey(Integer id);

    /***
     * 删除item
     * @param id
     * @return
     */
    @Delete("DELETE FROM items WHERE id=#{id};")
    int deteleByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKey(Item record);
    @Select(value = "SELECT * FROM items WHERE order_id>0 ORDER BY id LIMIT #{pageIndex},#{pageSize};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "price",column = "price"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodId",column = "good_id")
    })
    List<Item> seleItems(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);

    /****
     * 查询数据库中数据条数
     * @return
     */
    @Select(value = "SELECT count(id) AS id FROM items WHERE order_id>0;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "price",column = "price"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodId",column = "good_id")
    })
    int getCount();
    @Select(value = "SELECT *  FROM items WHERE id=#{itemid} AND order_id>0 ;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "price",column = "price"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodId",column = "good_id")
    })
    Item selectByGoodId(@Param("itemid") Integer itemid);
    @Select(value = "SELECT * FROM items WHERE order_id>0 ORDER BY id;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "price",column = "price"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodId",column = "good_id")
    })
    List<Item> selectItems();


}