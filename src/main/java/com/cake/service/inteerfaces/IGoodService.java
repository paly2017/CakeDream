package com.cake.service.inteerfaces;

import com.cake.pojo.Good;


import java.util.List;
import java.util.Map;

public interface IGoodService {
    /***
     * 根据类型id,查询对应的goods
     * @param integer
     * @return
     */
    Map<String,List<Good>> getGoodList(Integer integer);

    /***
     * Goods分页查询

     * @param typeId
     * @return
     */
    List<Good> getPageingGoods(Integer typeId);
}
