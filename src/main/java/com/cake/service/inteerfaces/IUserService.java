package com.cake.service.inteerfaces;

import com.cake.pojo.User;

public interface IUserService {

    /**
     * 根据用户id获取用户信息对象
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);
}
