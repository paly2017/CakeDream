package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import com.cake.uilt.Uilt;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginControl {
    @Autowired
   private UserServiceImpl userService;
    @PostMapping("/login")
    public ModelAndView doLogin(ModelAndView modelAndView,
                                @RequestParam("login_username")String username,
                                @RequestParam("login_password")String password,
                                HttpServletRequest request){

        return null;
    }

}
