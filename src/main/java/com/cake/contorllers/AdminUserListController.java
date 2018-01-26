package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 从页面跳转过来，请求显示所有用户信息
 */
@Controller
public class AdminUserListController {
    @Autowired
    private UserServiceImpl userService;
    //查询所有的用户信息，在用户详情页面显示
    @RequestMapping("/userList")
    public String searchAllUser(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        //调用获取用户对象集合
        List<User> userList = userService.findAllUser();
        System.out.println("获取到的用户集合是："+userList.toString());
        //将集合放入session中
        httpSession.setAttribute("userList",userList);
        //返回用户列表页面
        return "admin/user_list";
    }

    //根据用户id查询用户，准备修改用户密码
    @RequestMapping("/userReset")
    public String changeUserPwd(@RequestParam("userId")Integer userId){

        


        return "admin/user_reset";
    }


}
