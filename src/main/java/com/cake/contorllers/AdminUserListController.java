package com.cake.contorllers;

import com.cake.pojo.User;
import com.cake.service.Impl.UserServiceImpl;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
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
        //System.out.println("获取到的用户集合是："+userList.toString());
        //将集合放入session中
        httpSession.setAttribute("userList",userList);
        //返回用户列表页面
        return "admin/user_list";
    }

    //根据用户id查询用户，准备修改用户密码
    @RequestMapping("/userReset")
    public String changeUserPwd(@RequestParam("userId")Integer userId,
                                HttpServletRequest httpServletRequest
                                ){
        HttpSession httpSession = httpServletRequest.getSession();
        //获取用户对象
        User user = userService.getUserByUserId(userId);
        //用户放入session中
        httpSession.setAttribute("user",user);
        return "admin/user_reset";
    }
    //从页面获取用户填写的新密码，进行修改
    @RequestMapping("userResetChange")
    public String commitUserPwd(@RequestParam("userId")Integer userId,
                                @RequestParam("passWord") String passWord,
                                HttpServletRequest httpServletRequest
                                ) throws NoSuchAlgorithmException {
        HttpSession httpSession = httpServletRequest.getSession();
        List<User> userList = userService.findAllUser();
        //调用对用户密码加密的方法
        String newPassWord = UserUitl.encodeMD5(passWord);
        //将集合放入session中
        httpSession.setAttribute("userList",userList);
        //调用service方法修改密码
        userService.changeUserPwd(userId,newPassWord);
        //返回用户列表页面
        return "admin/user_list";
    }

    /**
     * 修改用户信息
     * @param userId
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/userEdit")
    public  String editUserMessage(@RequestParam("userId")Integer userId,
                                   HttpServletRequest httpServletRequest
                                    ){
        HttpSession httpSession = httpServletRequest.getSession();
        //获取用户对象
        User user = userService.getUserByUserId(userId);
        //用户放入session中
        httpSession.setAttribute("user",user);
        return "admin/user_edit";
    }

    /**
     * 修改用户信息
     * @param userId
     * @param phone
     * @param address
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("userEditOK")
    public String commitUserMessage(@RequestParam("userId")Integer userId,
                                    @RequestParam("user_phone") String phone,
                                    @RequestParam("user_address")String address,
                                    HttpServletRequest httpServletRequest

    ){
        //调用修改用户信息的方法
            Integer effectRow = userService.changeUserMes(userId,phone,address);
            System.out.println("修改用户信息被影响的行数"+effectRow);
        return "admin/user_list";
    }

}
