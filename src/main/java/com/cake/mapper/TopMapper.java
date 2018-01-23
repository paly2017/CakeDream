package com.cake.mapper;

import com.cake.pojo.Top;
import org.apache.ibatis.annotations.*;


import java.util.List;

//首页商品推荐的接口--显示首页商品--商品推荐表: tops
//字段：id  type  good_id

@Mapper
public interface TopMapper {
    //根据商品推荐表的类型查询首页展示--jelly
    @Select("SELECT * FROM tops WHERE `type`=#{type}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "type",column = "type"),
            @Result(property = "goodId",column = "good_id")
    })
    public List<Top> selectTopListByType(Integer type);

   //根据商品类型，起始下标、及页面容量 进行分页查询--jelly
    @Select("SELECT * FROM tops WHERE `type`=#{type} LIMIT #{fromIndex},#{pageSize};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "type",column = "type"),
            @Result(property = "goodId",column = "good_id")
    })
    public List<Top> selectByLimit(@Param("type") Integer type, @Param("fromIndex") Integer fromIndex, @Param("pageSize") Integer pageSize);


    //满哥
    int deleteByPrimaryKey(Integer id);

    int insert(Top record);

    int insertSelective(Top record);

    Top selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Top record);

    int updateByPrimaryKey(Top record);
}