package com.cake.mapper;

import com.cake.pojo.Top;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Top record);

    int insertSelective(Top record);

    Top selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Top record);

    int updateByPrimaryKey(Top record);
}