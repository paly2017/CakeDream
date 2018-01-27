package com.cake.service.Impl;

import com.cake.mapper.TypeMapper;
import com.cake.pojo.Type;
import com.cake.service.inteerfaces.ITypeService;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;
    //根据id查询商品类型,返回一个Type--jelly
    public Type selectTpyeById(Integer type_id) {
        return typeMapper.selectTpyeById(type_id);
    }

    /***
     * 商品类型的处理方法
     * @param request
     * @return
     */
    public String selectAllType(HttpServletRequest request) {
        List<Type> typeList = typeMapper.selectAllItemType();
        request.getSession().setAttribute("alltype",typeList);
        return Uilt.getGsonToString(typeList);
    }


    /**
     * 根据商品的type_id查询蛋糕系列的实体类
     * @param typeId 系列ID
     * @return 一个系列实体类
     * Philip
     */
    public Type findTypeByTypeId(Integer typeId) {
        //调用mapper里面的方法查询系列
        Type type = typeMapper.selectByPrimaryKey(typeId);
        return type;
    }

    //查询所有类目的接口
    public List<Type> selectAllItemType(){
        List<Type> list = typeMapper.selectAllItemType();
        System.out.println(list);
        return list;
    }



}
