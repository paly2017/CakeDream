package com.cake.service.Impl;

import com.cake.mapper.AdminMapper;
import com.cake.mapper.TypeMapper;
import com.cake.pojo.Admin;
import com.cake.service.inteerfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;


    public Admin getAdminById(Integer integer) {
        System.out.println("integer = [" + adminMapper + "]");
        return adminMapper.selectByPrimaryKey(integer);
    }
}
