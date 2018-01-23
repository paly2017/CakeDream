package com.cake.mapper;


import com.cake.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);


    /**
     * 数据库插入Order对象
     * @param order  对象
     * @return  返回被影响行数
     * INSERT INTO orders(total,amount,status,paytype,name,phone,address,systime,user_id) VALUES
    (233,4,2,1,'philip','1234456666','陕西西安','2018-01-16 17:16:51',1);
     */
    @Insert({"INSERT INTO orders(total,amount,status,paytype,name,phone,address,systime,user_id) VALUES " +
            "(${total},${amount},${status},${paytype},'${name}','${phone}','${address}','${systime}',${userId});"})
    int insert(Order order);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}