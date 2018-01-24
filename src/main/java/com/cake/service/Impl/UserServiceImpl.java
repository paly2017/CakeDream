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

    /**
     *给用户表插入数据实现类--返回受影响的行数
     */
    public User insertUser(String username,String password,String name,String phone,String address){
        User user=new User();
        try {
            String pasw=UserUitl.encodeMD5(password);
            if(userMapper.insertUser(username,password,name,phone,address)>0){
                user.setUsername(username);
                user.setPassword(pasw);
                user.setName(name);
                user.setPhone(phone);
                user.setAddress(address);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

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
            String  loginpassword = UserUitl.encodeMD5(password);
            User loginuser=  userMapper.selectByNameAndPass(username,loginpassword);
            if (null!=loginuser){
                Cookie cookie = new Cookie("userNamekey",username);
                System.out.println("cookie"+cookie.getName());
            }
            return loginuser;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /****
     * 查询Cookies中用户名是否存在
     * @param userName
     * @param request
     * @return
     */
    public boolean doCookies(String userName , HttpServletRequest request) {
        try {
            Cookie[] cookies =request.getCookies();
           if(null==cookies||cookies.length<1){
               return false;
           }
           for (Cookie cookie : cookies){

           }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }



    //用户注册处理实现类--判断用户名不重复
    //用户名判断处理接口
    public User selectUserByUsername(String username){
        //去数据库查询该用户
        User user = userMapper.selectUserByUserName(username);
        //返回
        return user;
    }
}
