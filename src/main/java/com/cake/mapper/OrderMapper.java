package com.cake.mapper;


import com.cake.pojo.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    @Delete("DELETE FROM orders WHERE id=#{id};")
    int deleteByPrimaryKey(@Param("id") Integer id);

    /**
     * 数据库插入Order对象
     * @param order  对象
     * @return  返回被影响行数
     * @author Philip
     * @Insert({"INSERT INTO orders(total,amount,status,paytype,name,phone,address,systime,user_id,order_NO) VALUES (#{total},#{amount},#{status},#{paytype},'#{name}','#{phone}','#{address}','#{systime}',#{userId},'#{orderNo}');"})
     */
    @Insert(" INSERT INTO orders(total,amount,status,paytype,name, phone, address,systime, user_id, order_NO ) " +
            "VALUES (#{total},#{amount},#{status},#{paytype},#{name},#{phone},#{address},#{systime},#{userId},#{orderNo});")
    Integer insert(Order order);

    int insertSelective(Order record);

    /***
     * 根据主键i查询order
     * @param id
     * @return
     */
    @Select(value = "SELECT * FROM orders WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "total",column = "total"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "status",column = "status"),
            @Result(property = "paytype",column = "paytype"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "address",column = "address"),
            @Result(property = "systime",column = "systime"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "orderNo",column = "order_No"),
            @Result(property = "delete",column = "delete_status")
    })
    Order selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(Order record);
    @Update(value = "UPDATE orders SET status=3 WHERE id=#{orderId}  ;")
    int updateByPrimaryKey(Integer orderId);

    /**
     * 查询数据库当前订单信息表中的最大id
     * @return  返回一个最大id
     */
    @Select("SELECT max(id) AS ID FROM orders")
    Integer searchMaxId();
    @Select("SELECT count(id) AS payID FROM orders WHERE status=#{payType}")
    Integer searchCountByPayStatus(@Param("payType")Integer payType);
    @Select(value = "SELECT * FROM orders WHERE paytype=#{pay}")
    List<Order> selectByPayType(@Param("pay") Integer pay);

}