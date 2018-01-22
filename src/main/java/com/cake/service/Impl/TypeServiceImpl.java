package com.cake.service.Impl;

import com.cake.mapper.TypeMapper;
import com.cake.pojo.Type;
import com.cake.service.inteerfaces.ITypeService;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;
    public String selectAllType() {
        List<Type> typeList = typeMapper.selectAllItemType();
        return Uilt.getGsonToString(typeList);
    }


    /**
     * 根据商品的type_id查询蛋糕系列的实体类
     * @param typeId 系列ID
     * @return 一个系列实体类
     */
    public Type findTypeBuTypeId(Integer typeId) {
        //调用mapper里面的方法查询系列
        Type type = typeMapper.selectByPrimaryKey(typeId);
        return type;
    }


}
