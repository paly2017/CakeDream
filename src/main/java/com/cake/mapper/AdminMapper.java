package com.cake.mapper;

import com.cake.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdminMapper {
    /**
     * 根主键id 删除数据
     * @param id
     * @return
     */

    int deleteByPrimaryKey(Integer id);

    /***
     * 增加admin数据
     * @param record
     * @return
     */
    int insert(Admin record);

    /***
     * 增加admin数据(选择性)
     * @param record
     * @return
     */

    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username") ,
            @Result(property = "password",column = "password")
    })
    int insertSelective(Admin record);

    /***
     * 根据id查询一个Admin
     * @param id
     * @return
     */
    @Select(value = "select id, username, password from admins where id = #{id,jdbcType=INTEGER}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username") ,
            @Result(property = "password",column = "password")
    })
    Admin selectByPrimaryKey(Integer id);

    /***
     * Admin数据更新（选择性的）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Admin record);
    /***
     * Admin数据更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Admin record);

    /***
     * 验证用户登录方法
     * @param username
     * @param password
     * @return
     */
    @Select(value = "select id, username, password from admins where username=#{username} and password=#{password}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username") ,
            @Result(property = "password",column = "password")
    })
    Admin selectCheck(@Param("username") String username,
                      @Param("password") String password);



    //根据用户名修改密码
    @Update("UPDATE admins SET `password`=#{password} WHERE username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username") ,
            @Result(property = "password",column = "password")
    })
    Integer modifyPassword(@Param("username") String username, @Param("password") String password);
}



