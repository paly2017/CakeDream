package com.cake.mapper;


import com.cake.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    /**
     * 将一个用户保存到数据库--插入数据库
     * @return
     */

    @Insert("INSERT INTO users(username,`password`,`name`,phone,address) VALUES (#{username},#{password},#{name},#{phone},#{address})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "address",column = "address")
    })
    Integer insertUser( @Param("username") String username,@Param("password")String password,@Param("name")String name,@Param("phone")String phone,@Param("address")String address);


    //根据用户名在数据库查询用户对象
    @Select("SELECT * FROM users WHERE username=#{username};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "address",column = "address")
    })
    User selectUserByUserName(String username );



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

    /****
     * 用户名密码
     * @param username
     * @param password
     * @return
     */
    @Select("SELECT * FROM users WHERE username=#{username} AND password=#{password} ;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "adress",column = "adress")
    })
    User selectByNameAndPass(@Param("username") String username,
                             @Param("password") String password);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}