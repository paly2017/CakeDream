package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class RegisterAjax {
    //注入UserServiceImpl实现类
    @Autowired
    private UserServiceImpl userServiceImpl;

    //处理用户名是否存在
    @PostMapping("/deal")
    public boolean selectUserByUsername(@RequestParam("username")String username){
        boolean flag =false;
        //调用根据用户名查询用户的方法
        User user= userServiceImpl.selectUserByUsername(username);
        if(user==null){
            flag =true;
        }
        return flag;
    }
}
