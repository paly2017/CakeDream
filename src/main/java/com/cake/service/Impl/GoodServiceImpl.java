package com.cake.service.Impl;

import com.cake.mapper.GoodMapper;
import com.cake.mapper.TypeMapper;
import com.cake.pojo.Good;
import com.cake.pojo.Type;
import com.cake.service.inteerfaces.IGoodService;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    //根据 商品 id 查询一个商品--jelly
    public Good slectGoodByGoodId(Integer good_id) {
        return goodMapper.slectGoodByGoodId(good_id);
    }
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
    /****
     * 根据GoodId查询good,返回一个json 字符串
     * @param goodID
     * @return
     */
    public String getOneGood(Integer goodID) {
        Good good = goodMapper.slectGoodByGoodId(goodID);
        System.out.println("goodID = [" + goodID + "]");
        if (null == good) {
            return "";
        }
        return Uilt.getGsonToString(good);
    }
    public String getOneGood(List<Integer> goodID) {
       List<Good> goodList = new ArrayList<Good>();
       for (Integer integer : goodID ){
           Good good = goodMapper.slectGoodsByGoodId(integer);
           if (null!=good){
               goodList.add(good);
           }
       }
        return Uilt.getGsonToString(goodList);
    }

    /**
     * 根据商品id查询商品
     * @param goodID  商品id
     * @return 商品对象
     * author Philip
     */
    public Good getGoodById(Integer goodID) {
        Good good = goodMapper.slectGoodsByGoodId(goodID);
        return good;
    }

}
