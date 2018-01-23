package com.cake.contorllers;

import com.cake.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginControl {
    @Autowired
   private UserServiceImpl userService;
}
