package com.cake.contorllers;

import com.cake.pojo.Admin;
import com.cake.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminControl {
    @Autowired
   private   AdminServiceImpl adminService;

    public ModelAndView doAdminLogin(ModelAndView modelAndView,
                                     @RequestParam("admin.username")String username,
                                     @RequestParam("admin.password")String password){
        Admin adminUser = new Admin();
        adminUser.setUsername(username);
        adminUser.setPassword(password);
        return null;
    }
}
