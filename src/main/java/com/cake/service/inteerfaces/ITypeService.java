package com.cake.service.inteerfaces;

import com.cake.pojo.Type;

import java.util.List;

public interface ITypeService {
    //根据id查询商品类型--jelly
    public Type selectTpyeById(Integer type_id);



    String selectAllType();


    /**
     * 根据蛋糕系列ID查询祷告系列
     * @param typeId
     * @return 一个实例蛋糕系列
     */
    Type findTypeBuTypeId(Integer typeId);



}
