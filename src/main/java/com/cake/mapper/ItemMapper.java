package com.cake.mapper;


import com.cake.pojo.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

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
}