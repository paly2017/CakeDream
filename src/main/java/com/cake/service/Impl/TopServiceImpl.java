package com.cake.service.Impl;

import com.cake.mapper.TopMapper;
import com.cake.pojo.Top;
import com.cake.service.inteerfaces.ITopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class TopServiceImpl implements ITopService {
    @Autowired
    private TopMapper topMapper;
    public List<Top> selectTopListByType(Integer type) {
        //根据商品类型查询推荐商品--得到一个List集合
        return  topMapper.selectTopListByType(type);
    }
    //根据商品类型，起始下标、及页面容量 进行分页查询--jelly
    public List<Top> selectByLimit(Integer type, Integer fromIndex, Integer pageSize) {
        return topMapper.selectByLimit(type,fromIndex,pageSize);
    }
}
