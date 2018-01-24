package com.cake.contorllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//个人中心页面跳转控制
@Controller
public class MyControl {
    @RequestMapping("/my")
    public String jumpMy(){
        return "index/my";
    }

}
