package com.cake.service.Impl;

import com.cake.mapper.GoodMapper;
import com.cake.mapper.TypeMapper;
import com.cake.pojo.Good;
import com.cake.pojo.Type;
import com.cake.service.inteerfaces.IGoodService;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements IGoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private TypeMapper typeMapper;

    private Map<String,List<Good>> stringGoodMap;
    /***
     * 根据商品类型id获取所有对应类型的商品
     * @param integer
     * @return Map<String,List<Good>>
     */
    public Map<String,List<Good>> getGoodList(Integer integer) {
        Type type = typeMapper.selectByPrimaryKey(integer);
        List<Good> goodList = goodMapper.selectGoodsByTypeId(integer);
        stringGoodMap = new HashMap<String, List<Good>>();
        stringGoodMap.put(type.getName(),goodList);
        return stringGoodMap;
    }

    /***
     * 根据下标，及类型id查询商品
     * @param typeId
     * @return
     */
    public List<Good> getPageingGoods(Integer typeId) {
        System.out.println("SELECT id,name,cover,image1,image2,price,intro,stock,type_id FROM goods" +
                "  WHERE type_id="+typeId+" ORDER BY id LIMIT "+Uilt.startSize+","+Uilt.pageSize+";");
        List<Good> goodList =goodMapper.selectGoosPageByIdAndIndex(typeId,Uilt.startSize,Uilt.pageSize);
        return goodList;
    }
}
