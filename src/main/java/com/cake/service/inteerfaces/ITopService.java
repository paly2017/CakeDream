package com.cake.service.inteerfaces;

import com.cake.pojo.Top;

import java.util.List;

//tops接口
public interface ITopService {
    //根据推荐类型从推荐表中查出首页显示商品--得到一个推荐表集合
    List<Top> selectTopListByType(Integer type);
    //根据商品类型，起始下标、及页面容量 进行分页查询--jelly
     List<Top> selectByLimit( Integer type,Integer fromIndex,Integer pageSize);
    //查出分页中每一页显示的商品，整合以上两个方法---传入参数，推荐类型、当前页码
   /* List<Top> oneShow(Integer type,Integer pageNum);*/
    //循环遍历，根据商品id查出商品，，根据商品type_id查出商品类型名称
    List<Top> foreach(List<Top> list);
    //查询商品id查询推荐
    Top selectTopByGoodId (Integer good_id);
    /**
     * 通过商品id，更改商品的推荐属性type，1、条幅  2、热销  3、新品
     */
    //移出条幅----根据商品id，在tops表中删除该字段
    //移出热销
    //移除新品
    Integer removeTops(Integer good_id);
//加入条幅--在tops表中插入 good_id  type字段--id自动生成,type:1、条幅  2、热销  3、新品
    //加入热销
    //加入新品
Integer addTops(Integer type,Integer good_id);

}
