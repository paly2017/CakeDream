package com.cake.service.Impl;

import com.cake.mapper.TopMapper;
import com.cake.pojo.Good;
import com.cake.pojo.Top;
import com.cake.pojo.Type;
import com.cake.service.inteerfaces.ITopService;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class TopServiceImpl implements ITopService {
    @Autowired
    private TopMapper topMapper;
    @Autowired
   private GoodServiceImpl goodServiceImpl;
    @Autowired
   private TypeServiceImpl typeServiceImpl;


    public  List<Top> selectTopListByType(Integer type) {
        //根据商品类型查询推荐商品--得到一个List集合
        List<Top> typeList= topMapper.selectTopListByType(type);
        List<Top> list =foreach(typeList);
        return  list;
    }
    //根据商品类型，起始下标、及页面容量 进行分页查询--jelly
    public List<Top> selectByLimit(Integer type, Integer fromIndex, Integer pageSize) {
        List<Top> limitList=topMapper.selectByLimit(type,fromIndex,pageSize);
        List<Top> list =foreach(limitList);
        return  list;
    }

/*    //查出分页中每一页显示的商品，整合以上两个方法---传入参数，推荐类型、当前页码
    public List<Top> oneShow(Integer type,Integer pageNum){
        //先根据推荐类型查询全部商品
        List<Top> AllList =selectTopListByType(type);
        //总共多少条数据
        Integer sum =AllList.size();
        Integer fromIndex= Uilt.getFromIndex(pageNum,sum);
      //分页查询得到每页显示的商品
        List<Top> limit =selectByLimit(type,fromIndex,Uilt.pageSize);
        //循环遍历，根据商品id查出商品，，根据商品type_id查出商品类型名称
        List<Top> list=foreach(limit);
        return list;
        //返回每页显示商品的集合
    }*/

    /**
     * 没有用
     * @return
     */
    //查询所有推荐商品
   public List<Top> selectAllTaops (){
       //调用topMapper实现类的全查方法
      List<Top> all= topMapper.selectAllTaops();
      //循环遍历集合，添加商品信息和type信息
       List<Top> allList=foreach(all);//调用goodServiceImpl的根据good_id查询商品的方法
       return allList;
   }



    //循环遍历，根据商品id查出商品，，根据商品type_id查出商品类型名称
    public  List<Top> foreach(List<Top> list) {
        for (Top top : list) {
            //根据good_id查出来一个商品
            Good good = goodServiceImpl.slectGoodByGoodId(top.getGoodId());
            //根据商品的type_id查出来一个Type
            Type type = typeServiceImpl.selectTpyeById(good.getTypeId());
            top.setGood(good);
            top.setGoodType(type);
        }
        return list;
    }

}
