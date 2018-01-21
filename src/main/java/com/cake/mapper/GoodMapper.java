package com.cake.mapper;


import com.cake.pojo.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface GoodMapper {
    @Select(value = "SELECT id,name,cover,image1,image2,price,intro,stock,type_id FROM goods  WHERE type_id=#{integer,jdbcType=INTEGER} ORDER BY id;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name") ,
            @Result(property = "cover",column = "cover"),
            @Result(property = "image1",column = "image1"),
            @Result(property = "image2",column = "image2"),
            @Result(property = "price",column = "price"),
            @Result(property = "intro",column = "intro"),
            @Result(property = "stock",column = "stock"),
            @Result(property = "typeId",column = "typeId")
    })
    List<Good> selectGoodsByTypeId(Integer integer);
}