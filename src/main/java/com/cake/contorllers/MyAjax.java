package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
@ResponseBody
public class MyAjax {
    //注入UserServiceImpl
    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping("/addInfo")
    public String addUserinfo(@RequestParam("name") String name ,
                              @RequestParam("phone") String phone ,
                              @RequestParam("address") String address ,
                              HttpServletRequest request){
        //获取到原来用户id、username、password
        User user= (User)request.getSession().getAttribute("loginUser");
        /*调用添加到数据库的方法*/
        Integer integer= userServiceImpl.updataInfo(user.getId(),name,phone,address);
        String data;
        if(integer>0){
            data="success";
        }else{
            data="false";
        }
        return data;
    }

    @PostMapping ("/modifyPsw")
    public String modifyPsw(@RequestParam("passwordNew") String password ,
                            HttpServletRequest request){
        String data;
        //获取到原来用户id、修改他的密码
        User user= (User)request.getSession().getAttribute("loginUser");
        /*调用添加到数据库的方法*/
        Integer integer= userServiceImpl.modefyPsw(user.getId(),password);
        if(integer>0){
            data= "success";
            request.getSession().removeAttribute("loginUser");
        }else{
            data= "false";
        }
        return data;
    }

    //检查输入的原密码是否正确
    @PostMapping("/check")
    public boolean checkPsw(@RequestParam("psw") String psw){
        boolean flag =false;
        try {
            //密码加密
            String pswMD5 = UserUitl.encodeMD5(psw);
            //根据密码查询用户信息
            User user= userServiceImpl.selectByPsw(pswMD5);

            //判断是否正确--用户为空，输入错误
            if(user!=null){
                //返回boolean值
                flag =true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
