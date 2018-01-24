package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import com.cake.uilt.Uilt;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginControl {
    @Autowired
   private UserServiceImpl userService;

    /***
     * NND登录页面跳转
     * @return
     */
    @RequestMapping("/sendlogin")
    public String sendLogin(){
        return "index/login";
    }
    /***
     * 处理用户登录方法
     * @param modelAndView
     * @param username
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ModelAndView doLogin(ModelAndView modelAndView,
                                @RequestParam("login_username")String username,
                                @RequestParam("login_password")String password,
                                HttpServletRequest request){
       User user =  userService.doLogingService(username,password,request);

       if (null==user){
           modelAndView.setViewName("index/login");
           modelAndView.addObject("error","用户名密码错误！！！");
       }else {
           modelAndView.setViewName("index");
           request.getSession().setAttribute("loginUser",user);
       }
        return modelAndView;
    }

}
