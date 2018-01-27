package com.cake.mapper;


import com.cake.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    //将一个用户保存到数据库--插入数据库---注册---返回int受影响的行数
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


    //根据用户名在数据库查询用户对象--返回用户对象
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


    //个人中心页面修改地址--返回int受影响的行数
   @Update("UPDATE users SET `name`=#{name},phone=#{phone},address=#{address} WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "address",column = "address")
    })
    Integer updataInfo(@Param("id")Integer id, @Param("name")String name,@Param("phone")String phone,@Param("address")String address);


    //根据密码查询用户信息--返回用户对象
    @Select("SELECT * FROM users WHERE password=#{password};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "adress",column = "adress")
    })
    User selectByPsw(@Param("password")String password);

    //修改密码--返回int受影响的行数
    @Update("UPDATE users SET `password`=#{password} WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "adress",column = "adress")
    })
    Integer modefyPsw(@Param("id")Integer id,@Param("password")String password);




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
    User selectByPrimaryKey(@Param("userId") Integer id);

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


    /**
     * 查询数据库所有用户信息，在后台管理页面显示
     * @return 用户对象集合
     * @author Philip
     */
    @Select("SELECT * FROM users;")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "adress",column = "adress")
    })
    List<User> selectAllUser();

    /**
     * 根据用户id修改用户登录密码
     * @return 被影响行数
     */
    @Update("UPDATE users SET password=#{password } WHERE id=#{id };")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "adress",column = "adress")
    })
    Integer changeUserPwd(@Param("id")Integer id,@Param("password")String password);
}