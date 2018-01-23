package com.cake.mapper;


import com.cake.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);




    int insert(User record);

    int insertSelective(User record);

    /**
     * 根据用户ID获取用户信息对象
     * @param id 用户id
     * @return 用户对象
     */
    @Select("SELECT * FROM users WHERE id=#{userId};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "adress",column = "adress")
    })
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}