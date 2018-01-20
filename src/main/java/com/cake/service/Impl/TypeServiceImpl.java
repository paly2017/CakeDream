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
}
