package com.cake.contorllers;

import com.cake.pojo.Admin;
import com.cake.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        System.out.println("进来");
        Admin adminUser = new Admin();
        adminUser.setUsername(username);
        adminUser.setPassword(password);
        try {
            if (adminService.AdminCheckLogin(adminUser,request)){
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
}
