package com.cake.service.Impl;

import com.cake.mapper.UserMapper;
import com.cake.pojo.User;
import com.cake.service.inteerfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;


    public User getUserByUserId(Integer userId) {

        //调用映射的根据id查询用户信息的方法
        User user = userMapper.selectByPrimaryKey(userId);
        //返回一个用户对象
        return user;
    }
}
