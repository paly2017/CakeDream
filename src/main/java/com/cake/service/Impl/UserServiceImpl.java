package com.cake.service.Impl;

import com.cake.mapper.UserMapper;
import com.cake.pojo.User;
import com.cake.service.inteerfaces.IUserService;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;


    public User getUserByUserId(Integer userId) {

        //调用映射的根据id查询用户信息的方法
        User user = userMapper.selectByPrimaryKey(userId);
        //返回一个用户对象
        return user;
    }

    /****
     * 用户登录验证service
     * @param username
     * @param password
     * @param request
     * @return
     */
    public User doLogingService(String username, String password, HttpServletRequest request) {
        try {
            Cookie[] cookies =request.getCookies();
            User loginUser = new User();
            loginUser.setName(username);
            loginUser.setPassword(UserUitl.encodeMD5(password));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean doCookies(String userName , HttpServletRequest request) {
        try {
            Cookie[] cookies =request.getCookies();
            String strUser = UserUitl.encodeMD5(userName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
