package com.cake.contorllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制购物车跳转
@Controller
public class cartControl {
    @RequestMapping("/cart")
    public String jumpCart(){
        return "index/cart";
    }
}
