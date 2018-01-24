package com.cake.service.inteerfaces;

import com.cake.pojo.Good;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface IGoodService {

    //根据商品 id,查询一个对应的good--jelly
  public Good slectGoodByGoodId(Integer good_id);
    /***
     * 根据类型id,查询对应的goods
     * @param integer
     * @return
     */
    Map<String,List<Good>> getGoodList(Integer integer);
    /***
     * Goods分页查询

     * @param typeId
     * @return
     */
    List<Good> getPageingGoods(Integer typeId);

    /***
     * 根据GoodId查询good
     * @param goodID
     * @return
     */

    String getOneGood(Integer goodID);

    /**
     * 根据商品ID查询商品
     * @param goodID  商品id
     * @return 一个商品对象
     */
    Good getGoodById(Integer goodID);

    /***
     * 根据goodid集合查询goods,返回一个json字符串
     * @param goodID
     * @return
     */
    String getOneGood(List<Integer> goodID);

    String mincartGoodSrevice(Integer integer, HttpServletRequest request);

  String mincartGoodSrevice(HttpSession session);

}
