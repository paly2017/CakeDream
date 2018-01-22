package com.cake.service.inteerfaces;

import com.cake.pojo.Top;

import java.util.List;

//tops接口
public interface ITopService {
    //根据推荐类型从推荐表中查出首页显示商品--得到一个推荐表集合
    public List<Top> selectTopListByType(Integer type);
}
