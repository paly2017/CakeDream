package com.cake.service.inteerfaces;

import com.cake.pojo.User;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {

    /**
     * 根据用户id获取用户信息对象
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);

    /**
     *给用户表插入数据
     */
     User insertUser(String username,String password,String name,String phone,String address);

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
