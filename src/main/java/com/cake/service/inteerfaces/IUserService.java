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

    /***
     * 用户登录处理方法
     * @param username
     * @param password
     * @param request
     * @return
     */
    User doLogingService(String username,String password,HttpServletRequest request);

    boolean doCookies(String userName ,HttpServletRequest request);
}
