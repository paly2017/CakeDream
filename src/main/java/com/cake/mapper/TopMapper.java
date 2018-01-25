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
    public List<Top> selectTopListByType(@Param("type") Integer type);

   //根据商品类型，起始下标、及页面容量 进行分页查询--jelly
    @Select("SELECT * FROM tops WHERE `type`=#{type} LIMIT #{fromIndex},#{pageSize};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "type",column = "type"),
            @Result(property = "goodId",column = "good_id")
    })
     List<Top> selectByLimit(@Param("type") Integer type, @Param("fromIndex") Integer fromIndex, @Param("pageSize") Integer pageSize);


    //查询商品id查询推荐
    @Select("SELECT * FROM tops WHERE good_id=#{good_id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "type",column = "type"),
            @Result(property = "goodId",column = "good_id")
    })
    List<Top> selectTopByGoodId (@Param("good_id") Integer good_id);
 /**
  * 通过商品id，更改商品的推荐属性type，1、条幅  2、热销  3、新品
  */
    //移出条幅----根据商品id，在tops表中删除该字段
    //移出热销
    //移除新品
    @Delete("DELETE * FROM tops WHERE good_id=#{good_id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "type",column = "type"),
            @Result(property = "goodId",column = "good_id")
    })
    Integer removeTops(@Param("good_id") Integer good_id);

    //加入条幅--在tops表中插入 good_id  type字段--id自动生成,type:1、条幅  2、热销  3、新品
    //加入热销
    //加入新品

    @Insert("INSERT INTO tops(`type`,good_id) VALUES('#{type}','#{good_id}');")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "type",column = "type"),
            @Result(property = "goodId",column = "good_id")
    })
    Integer addTops(@Param("type")Integer type,@Param("good_id")Integer good_id);

    //


    //满哥
    int deleteByPrimaryKey(Integer id);

    int insert(Top record);

    int insertSelective(Top record);

    Top selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Top record);

    int updateByPrimaryKey(Top record);
}