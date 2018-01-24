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
     */
    @Insert({"INSERT INTO orders(total,amount,status,paytype,name,phone,address,systime,user_id) VALUES " +
            "(${total},${amount},${status},${paytype},'${name}','${phone}','${address}','${systime}',${userId});"})
    int insert(Order order);

    int insertSelective(Order record);

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