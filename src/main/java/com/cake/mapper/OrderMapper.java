package com.cake.mapper;


import com.cake.pojo.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

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
            @Result(property = "orderNo",column = "order_No")
    })
    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 查询数据库当前订单信息表中的最大id
     * @return  返回一个最大id
     */
    @Select("SELECT max(id) AS ID FROM orders")
    Integer searchMaxId();
}