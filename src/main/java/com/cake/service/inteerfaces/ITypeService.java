package com.cake.service.inteerfaces;

import com.cake.pojo.Type;

import java.util.List;

public interface ITypeService {

    String selectAllType();


    /**
     * 根据蛋糕系列ID查询祷告系列
     * @param typeId
     * @return 一个实例蛋糕系列
     */
    Type findTypeBuTypeId(Integer typeId);



}
