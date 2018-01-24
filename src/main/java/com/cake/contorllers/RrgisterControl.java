package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//控制注册页面的control
@Controller
public class RrgisterControl {
    //注入UserServiceImpl实现类
    @Autowired
   private UserServiceImpl userServiceImpl;

    @RequestMapping("/reg")
    public ModelAndView jumpReg(ModelAndView modelAndView){
        modelAndView.setViewName("index/register");
        return modelAndView;
    }


    @RequestMapping("/register")
    //获取表单提交的参数
    public ModelAndView dealReg(@RequestParam("username") String username ,
                                @RequestParam("password") String password ,
                                @RequestParam("name") String name ,
                                @RequestParam("phone") String phone ,
                                @RequestParam("address") String address ,
                                ModelAndView modelAndView,
                                HttpServletRequest request){
        //调用用户处理的方法,将用户保存到数据库
        //封装成用户对象
      User user = userServiceImpl.insertUser(username,password,name,phone,address);
        request.getSession().setAttribute("loginUser",user);
        modelAndView.setViewName("/index");
        return modelAndView;
    }

}
