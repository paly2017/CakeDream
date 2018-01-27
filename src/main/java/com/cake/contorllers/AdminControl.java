package com.cake.contorllers;

import com.cake.pojo.Admin;
import com.cake.service.Impl.AdminServiceImpl;
import com.cake.uilt.Uilt;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Controller
public class AdminControl {
    @Autowired
   private   AdminServiceImpl adminService;
    @RequestMapping("/goadmin")
    public String sendAdminRequest(){
        return "admin/login";
    }

    /****
     * 后台管理用户登录处理控制器
     * @param modelAndView
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/adminlogin")
    public ModelAndView doAdminLogin(ModelAndView modelAndView,
                                     @RequestParam("admin.username")String username,
                                     @RequestParam("admin.password")String password,
                                     HttpServletRequest request){
        Admin adminUser = new Admin();
        adminUser.setUsername(username);
        adminUser.setPassword(password);
        try {
            if (adminService.AdminCheckLogin(adminUser,request)){
                request.getSession().setAttribute("admin",adminUser);
                modelAndView.setViewName("admin/index");
                return modelAndView;
            }
        } catch (NoSuchAlgorithmException e) {
            modelAndView.setViewName("admin/login");
            e.printStackTrace();
        }
        modelAndView.setViewName("admin/login");
        return modelAndView;
    }

    //跳到修改密码页面
    @RequestMapping("/admin")
    public String jumpAdmin(){
       return "admin/admin_reset";
    }

    //判断用户密码是否正确
    @PostMapping("/checkAdmin")
    @ResponseBody
    public boolean checkyAdmin(@RequestParam("username")String username,
                               @RequestParam("psw")String password){

         boolean flag=false;
        try {
            //密码加密
            String psw =UserUitl.encodeMD5(password);
            //根据管理员的密码，去数据库查用户，有，返回true,无，返回false
            Admin admin= adminService.selectAdmin(username,psw);
            if(admin!=null){
                flag=true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return flag;
    }

    //修改管理员密码
    @PostMapping("/reAdmin")
    public String modifyAdmin(@RequestParam("passwordNew")String password,
                                HttpServletRequest request){
        try {
            //获取用户名
           Admin admin= (Admin) request.getSession().getAttribute("admin");
            String psw =UserUitl.encodeMD5(password);
            Integer a=  adminService.modifyPassword(admin.getUsername(),psw);
            if(a>0){
                return "admin/login";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "admin/admin_reset";
    }
}
