package com.cake.service.inteerfaces;

import com.cake.pojo.Good;
import com.cake.pojo.Type;

import java.util.List;
import java.util.Map;

public interface IGoodService {
    /***
     * 根据类型id,查询对应的goods
     * @param integer
     * @return
     */
    Map<String,List<Good>> getGoodList(Integer integer);
}
