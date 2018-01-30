package com.cake.service.Impl;

import com.cake.mapper.GoodMapper;
import com.cake.mapper.TypeMapper;
import com.cake.pojo.Good;
import com.cake.pojo.MiniCart;
import com.cake.pojo.Type;
import com.cake.service.inteerfaces.IGoodService;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class GoodServiceImpl implements IGoodService {
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private TypeMapper typeMapper;

    private Map<String,List<Good>> stringGoodMap;

    //根据 商品 id 查询一个商品--jelly
    public Good slectGoodByGoodId(Integer good_id) {
        return goodMapper.slectGoodByGoodId(good_id);
    }
    /***
     * 根据商品类型id获取所有对应类型的商品
     * @param integer
     * @return Map<String,List<Good>>
     */
    public Map<String,List<Good>> getGoodList(Integer integer) {
        Type type = typeMapper.selectByPrimaryKey(integer);
        List<Good> goodList = goodMapper.selectGoodsByTypeId(integer);
        stringGoodMap = new HashMap<String, List<Good>>();
        stringGoodMap.put(type.getName(),goodList);
        return stringGoodMap;
    }

    /***
     * 根据下标，及类型id查询商品
     * @param typeId
     * @return
     */
    public List<Good> getPageingGoods(Integer typeId) {
        System.out.println("SELECT id,name,cover,image1,image2,price,intro,stock,type_id FROM goods" +
                "  WHERE type_id="+typeId+" ORDER BY id LIMIT "+Uilt.startSize+","+Uilt.pageSize+";");
        List<Good> goodList =goodMapper.selectGoosPageByIdAndIndex(typeId,Uilt.startSize,Uilt.pageSize);
        return goodList;
    }
    /****
     * 根据GoodId查询good,返回一个json 字符串
     * @param goodID
     * @return
     */
    public String getOneGood(Integer goodID) {
        Good good = goodMapper.slectGoodByGoodId(goodID);
        System.out.println("goodID = [" + goodID + "]");
        if (null == good) {
            return "";
        }
        return Uilt.getGsonToString(good);
    }

    /***
     *
     * @param goodID
     * @return
     */
    public String getOneGood(List<Integer> goodID) {
       List<Good> goodList = new ArrayList<Good>();
       for (Integer integer : goodID ){
           Good good = goodMapper.slectGoodsByGoodId(integer);
           if (null!=good){
               goodList.add(good);
           }
       }
        return Uilt.getGsonToString(goodList);
    }

    /***
     * 处理miniCart(立即购买，和加入购物车功能)
     * @param integer goodId
     * @param request
     * @return
     */
    public String mincartGoodSrevice(Integer integer, HttpServletRequest request) {
        MiniCart miniCart=null;
        Integer oldgoodId=null;
        //从session中获取mini购物车数据
       List<MiniCart> miniCartList =
               (List<MiniCart>)request.getSession().getAttribute("minGoodsNum");
       //判断mini购物车数据中数据是否为空
       if (null!=miniCartList){
           //判断集合中购物车的good_id是否存在
           for (MiniCart itemgood : miniCartList){
               //更新已存在商品数量
               if (itemgood.getGood().getId().equals(integer)){
                   if (itemgood.getCount()<=itemgood.getGood().getStock()){
                       itemgood.setCount(itemgood.getCount()+1);
                       oldgoodId = itemgood.getGood().getId();
                       break;
                   }
               }
           }
           if (null==oldgoodId){
               Good good = goodMapper.slectGoodByGoodId(integer);
               miniCart = new MiniCart();
               miniCart.setGood(good);
               miniCart.setCount(1);
               miniCartList.add(miniCart);
               request.getSession().setAttribute("minGoodsNum",miniCartList);
           }
       }
       if (null==miniCartList){
           miniCartList = new ArrayList<MiniCart>();
           Good good = goodMapper.slectGoodByGoodId(integer);
           if (null!=good){
               miniCart = new MiniCart();
               miniCart.setGood(good);
               miniCart.setCount(1);
               miniCartList.add(miniCart);
               request.getSession().setAttribute("minGoodsNum",miniCartList);
           }
       }

        System.out.println("integer = "+Uilt.getGsonToString(miniCartList));
        return Uilt.getGsonToString(miniCartList);
    }

    /***
     * 页面刷新时，更新mini购物车信息
     * @param session
     * @return
     */
    public String mincartGoodSrevice(HttpSession session) {
       List<MiniCart> miniCartList =
               (List<MiniCart>) session.getAttribute("minGoodsNum");
       if (null!=miniCartList){
           System.out.println("session = [" + miniCartList + "]");
           return  Uilt.getGsonToString(miniCartList);
       }else {
           return "";
       }
    }

    /****
     * 计算购物车中商品总价钱
     * @param request
     * @return
     */
    public Integer getTotalPrice(HttpServletRequest request) {
        Integer totalPrice = 0;
        List<MiniCart> miniCartList =
                (List<MiniCart> )request.getSession().getAttribute("minGoodsNum");
        if (miniCartList==null){
            return Integer.valueOf("0");
        }
        for (MiniCart miniCart : miniCartList){
            int price = miniCart.getGood().getPrice();
            int count = miniCart.getCount();
            totalPrice+=price*count;
        }
        return totalPrice;
    }
    //查询全部商品
    public List<Good> selectAllGood() {
        return goodMapper.selectAllGood();
    }
    //分页查询所有商品
    public List<Good> selectLimitGood(Integer fromIndex, Integer pageSize) {
        return goodMapper.selectLimitGood(fromIndex,pageSize);
    }

    /**
     * 根据商品id获取一系列商品集合
     * @param httpSession
     * @return
     * @author Philip
     */
    public List<Good> packagingGood(HttpSession httpSession) {
        //获取session中存放的MiniCart集合
        List<MiniCart> miniCartList = (List<MiniCart>) httpSession.getAttribute("minGoodsNum");
        List<Good> goodList = new ArrayList<Good>();
        for (MiniCart miniCart:
                miniCartList) {
            goodList.add(this.slectGoodByGoodId(miniCart.getGood().getId()));
        }
        return goodList;
    }

    /**
     * 根据商品id查询商品
     * @param goodID  商品id
     * @return 商品对象
     * author Philip
     */
    public Good getGoodById(Integer goodID) {
        Good good = goodMapper.slectGoodsByGoodId(goodID);
        return good;
    }
    //添加商品
   public Integer addGood(String name,String cover,String image1,String image2,Integer price,String intro,Integer stock,Integer typeId){
       return goodMapper.addGood(name,cover,image1,image2,price,intro,stock,typeId);
    }


    // /商品编辑，更新商品信息
   public Integer editorGood( Integer id, String name,String cover,String image1,String image2,Integer price,String intro,Integer stock,Integer typeId){
        return goodMapper.editorGood(id,name,cover,image1,image2,price,intro,stock,typeId);
   }

}
