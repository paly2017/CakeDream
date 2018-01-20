package com.cake.contorllers;

import com.cake.pojo.Admin;
import com.cake.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    @Autowired
   private AdminServiceImpl adminService;
    @RequestMapping("/say")
    public String say(){
        System.out.println(adminService);
      Admin admin = adminService.getAdminById(1);
        System.out.println(admin);
        return "hello";
    }
}
