package com.cake.service.Impl;

import com.cake.mapper.GoodMapper;
import com.cake.mapper.TypeMapper;
import com.cake.pojo.Good;
import com.cake.pojo.Type;
import com.cake.service.inteerfaces.ITypeService;
import com.cake.uilt.Uilt;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private GoodMapper goodMapper;
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

    public boolean addGoodType(Type type) {
        Type oldType = typeMapper.selectGoodType(type.getName());
        if (null!=oldType){
            return false;
        }else {
            int count = typeMapper.insertByTypeName(type.getName());
            if(count>0){
                return true;
            }
        }
        return false;
    }

    /***
     * 商品类型修改
     * @param typeId
     * @return
     */
    public boolean changeTypeService(Integer typeId,String name) {
        Optional.of(typeId);
        int count =  typeMapper.updateByPrimaryKey(typeId,name);
        if (count>0){
            return true;
        }
        return false;
    }

    /***
     * 数据库数据删除
     * @param typeId
     * @return
     */
    public boolean deteleTypeService(Integer typeId) {
        Optional.of(typeId);
        List<Good> goodList=goodMapper.selectGoodsByTypeId(typeId);
        if (goodList==null||goodList.size()==0){
            typeMapper.deteleType(typeId);
            return true;
        }
        return false;
    }


}
