package com.cake.contorllers;

import com.cake.pojo.Admin;
import com.cake.service.Impl.AdminServiceImpl;
import com.cake.uilt.UserUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class Test {
    @Autowired
   private AdminServiceImpl adminService;
    @RequestMapping("/say")
    public String say(){
        System.out.println(adminService);
      Admin admin = adminService.getAdminById(1);
        System.out.println(admin);
        return "index/herder";
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        ;
        System.out.println(UserUitl.encodeMD5("admin"));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:ssss");
        String orderDate = simpleDateFormat.format(date);
        System.out.println(orderDate);
        long s = System.currentTimeMillis();

        System.out.println(s);
        Random random = new Random(555L);

            System.out.println("random"+random.nextInt());

    }


}
