package com.cake.mapper;


import com.cake.pojo.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface GoodMapper {
    /***
     * 根据类型id查询Goods
     * @param integer
     * @return
     */
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
            @Result(property = "typeId",column = "type_id")
    })
    List<Good> selectGoodsByTypeId(Integer integer);

    /***
     * 根据类型分页查询Goods
     * @param integer
     * @param index
     * @param size
     * @return
     */

    @Select(value ="SELECT id,name,cover,image1,image2,price,intro,stock,type_id FROM goods WHERE type_id=#{integer} ORDER BY id LIMIT #{index},#{size};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name") ,
            @Result(property = "cover",column = "cover"),
            @Result(property = "image1",column = "image1"),
            @Result(property = "image2",column = "image2"),
            @Result(property = "price",column = "price"),
            @Result(property = "intro",column = "intro"),
            @Result(property = "stock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    List<Good> selectGoosPageByIdAndIndex(@Param("integer") Integer integer,
                                          @Param("index") Integer index,
                                          @Param("size") Integer size);

    /****
     * 根据GoodId查询good
     * @param goodId
     * @return
     */
    @Select(value = "SELECT id,name,cover,image1,image2,price,intro,stock,type_id FROM goods  WHERE id=#{goodId,jdbcType=INTEGER};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name") ,
            @Result(property = "cover",column = "cover"),
            @Result(property = "image1",column = "image1"),
            @Result(property = "image2",column = "image2"),
            @Result(property = "price",column = "price"),
            @Result(property = "intro",column = "intro"),
            @Result(property = "stock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })

    Good slectGoodsByGoodId(Integer goodId);
}