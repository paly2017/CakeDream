package com.cake.service.Impl;

import com.cake.mapper.AdminMapper;
import com.cake.mapper.TypeMapper;
import com.cake.pojo.Admin;
import com.cake.pojo.User;
import com.cake.service.inteerfaces.IAdminService;
import com.cake.uilt.UserUitl;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;


    public Admin getAdminById(Integer integer) {

        return adminMapper.selectByPrimaryKey(integer);
    }

    /***
     * 管理用户登录处理
     * @param admin
     * @return
     */
    public boolean AdminCheckLogin(Admin admin, HttpServletRequest request)
            throws NoSuchAlgorithmException {
        Optional.of(admin);
       Admin admin1 = adminMapper.selectCheck(admin.getUsername(), UserUitl.encodeMD5(admin.getPassword()));
       if (admin1!=null){
           return true;
       }
        return false;
    }

    //根据用户名和密码去数据库查询
    public Admin selectAdmin(String username,String password){
        return adminMapper.selectCheck(username,password);
    }


  public   Integer modifyPassword(String username,String password){
        return adminMapper.modifyPassword(username,password);
  }
}
