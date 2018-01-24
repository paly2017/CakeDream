package com.cake.service.inteerfaces;

import com.cake.pojo.User;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {



    /**
     *给用户表插入数据---返回用户对象，封装要用到
     */
     User insertUser(String username,String password,String name,String phone,String address);

    /**
     *   个人中心页面修改地址--返回int受影响的行数
     */
     Integer updataInfo(Integer id,String name,String phone,String address);
    /**
     * 根据密码查询用户信息---返回用户对象
     */
    User selectByPsw(String password);
    /**
     *  修改密码--返回int受影响的行数
     */
    Integer modefyPsw(Integer id,String password);


    /**
     * 根据用户id获取用户信息对象
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);
    /***
     * 用户登录处理方法
     * @param username
     * @param password
     * @param request
     * @return
     */
    User doLogingService(String username,String password,HttpServletRequest request);

    boolean doCookies(String userName ,HttpServletRequest request);

    //用户名判断处理接口
     User selectUserByUsername(String username);
}
