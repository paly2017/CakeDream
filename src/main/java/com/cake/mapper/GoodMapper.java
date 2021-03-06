package com.cake.mapper;


import com.cake.pojo.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface GoodMapper {

    //根据商品 id 查询单个商品--jelly
    @Select("SELECT * FROM goods WHERE id=#{good_id}")
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
     public Good slectGoodByGoodId(@Param("good_id") Integer good_id);




    /***
     * 根据类型 id查询Goods
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

    @Select("SELECT * FROM goods WHERE id=#{goodId};;")
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

    //查询全部商品
    @Select("SELECT * FROM goods;")
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
    List<Good> selectAllGood();

    //分页查询所有商品
    @Select("SELECT * FROM goods LIMIT #{fromIndex},#{pageSize};")
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
    List<Good> selectLimitGood(@Param("fromIndex") Integer fromIndex,@Param("pageSize")Integer pageSize);

    //添加商品
    @Insert("INSERT INTO goods(`name`,cover,image1,image2,price,intro,stock,type_id) VALUES(#{name},#{cover},#{image1},#{image2},#{price},#{intro},#{stock},#{typeId});")
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
    Integer addGood(@Param("name") String name,@Param("cover")String cover,@Param("image1")String image1,@Param("image2")String image2,@Param("price")Integer price,@Param("intro")String intro,@Param("stock")Integer stock,@Param("typeId")Integer typeId);


    //商品编辑，更新商品信息
    @Update("UPDATE goods SET `name`=#{name} ,cover=#{cover} ,image1=#{image1}, image2=#{image2}, price=#{price},intro=#{intro}, stock=#{stock},type_id=#{typeId} WHERE id=#{id}")
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
    Integer editorGood(@Param("id") Integer id,@Param("name") String name,@Param("cover")String cover,@Param("image1")String image1,@Param("image2")String image2,@Param("price")Integer price,@Param("intro")String intro,@Param("stock")Integer stock,@Param("typeId")Integer typeId);

}