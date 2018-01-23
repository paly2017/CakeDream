package com.cake.mapper;

import com.cake.pojo.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface TypeMapper {
//types表---字段  id   name
    //根据id查询商品类型--jelly
    @Select("SELECT * FROM  `types` WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })

    public Type selectTpyeById(Integer type_id);
    //结束





    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    /**
     * 根据系列类型id查询系列对象
     * @param typeId 蛋糕系列id
     * @return 一个系列实例
     */
    @Select(value = "SELECT id,name FROM types WHERE id=#{typeId } ")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    Type selectByPrimaryKey(@Param("typeId") Integer typeId);




    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
    @Select(value = "SELECT id,name FROM types WHERE 1=1;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<Type> selectAllItemType();







}