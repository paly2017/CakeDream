package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

//个人中心页面跳转控制
@Controller
public class MyControl {
    //注入UserServiceImpl
    @Autowired
    private UserServiceImpl userServiceImpl;
    @RequestMapping("/my")
    public String jumpMy(){
        return "index/my";
    }

}
