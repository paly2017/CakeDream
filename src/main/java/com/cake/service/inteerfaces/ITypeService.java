package com.cake.service.inteerfaces;

import com.cake.pojo.Type;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ITypeService {
    //根据id查询商品类型--jelly
    public Type selectTpyeById(Integer type_id);
    /***
     * 返回全部商品类型的Json 字符串
     * @param request
     * @return
     */
    String selectAllType(HttpServletRequest request);
    /**
     * 根据蛋糕系列ID查询蛋糕系列
     * @param typeId
     * @return 一个实例蛋糕系列
     */
    Type findTypeByTypeId(Integer typeId);

   /* //根据用户type_id查询商品类型
    Type selectTypeByGoodId();*/

    //查询所有类目的接口
    List<Type> selectAllItemType();


}
