package com.cake.mapper;

import com.cake.pojo.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
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
    /***
     * 增加商品类型
     * @param typeName
     * @return
     */
    @Insert("INSERT INTO types(name) VALUES(#{taypename})")
    int insertByTypeName(@Param("taypename") String  typeName);

    /***
     * 修改商品类型名字
     * @param typeId
     * @param name
     * @return
     */
    @Update("UPDATE types SET  name=#{name} WHERE id = #{typeId};")
    int updateByPrimaryKey(@Param("typeId") Integer typeId,@Param("name") String name);

    /****
     * 商品类型全查
     * @return
     */
    @Select(value = "SELECT id,name FROM types WHERE 1=1;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<Type> selectAllItemType();
    @Select(value = "SELECT id,name FROM types WHERE name=#{typeName};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    Type selectGoodType(@Param("typeName") String typeName);

    /***
     * 删除商品id
     * @param typeId
     * @return
     */
    @Delete("DELETE FROM types WHERE id=#{typeId};")
    int deteleType(@Param("typeId") Integer typeId);






}