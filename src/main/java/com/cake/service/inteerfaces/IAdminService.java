package com.cake.service.inteerfaces;

import com.cake.pojo.Admin;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

public interface IAdminService {
    Admin getAdminById(Integer integer);

    /***
     * 判断Admin用户登录
     * @param admin
     * @return
     */
    boolean AdminCheckLogin(Admin admin, HttpServletRequest request)
            throws NoSuchAlgorithmException;


    //根据用户名修改密码
    Integer modifyPassword( String username,  String password);
}
