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
import java.util.List;

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
     *给用户表插入数据实现类--返回一个用户类
     */
    public User insertUser(String username,String password,String name,String phone,String address){
        //创建用户类
        User user=new User();
        try {
            //密码用MD5，加密
            String pasw=UserUitl.encodeMD5(password);
            if(userMapper.insertUser(username,pasw,name,phone,address)>0){
                //封装用户信息
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

    /**
     *  个人中心修改地址的方法
     */
    public Integer updataInfo(Integer id, String name, String phone, String address) {
        //调用 userMapper借口实现类的方法
       Integer i= userMapper.updataInfo(id,name, phone, address);
        return i;
    }
    /**
     * 根据密码查询用户信息
     */
    public User selectByPsw(String password) {
        return userMapper.selectByPsw(password);
    }
    /**
     *  修改密码--返回int受影响的行数
     */
    public Integer modefyPsw(Integer id, String password) {
        return userMapper.modefyPsw(id,password);
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

    /**
     * 查询数据库所有用户信息
     * 在后台管理页面显示
     * @return 返回用户集合
     */
    public List<User> findAllUser() {
        //System.out.println("进入查询用户信息的实现接口方法");
        //调用方法查询用户信息
        List<User> userList = userMapper.selectAllUser();
        //System.out.println("调用了userMapper映射的方法");
        return userList;
    }
}
