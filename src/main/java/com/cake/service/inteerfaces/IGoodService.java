package com.cake.service.inteerfaces;

import com.cake.pojo.Good;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface IGoodService {

    //根据商品 id,查询一个对应的good--jelly
   Good slectGoodByGoodId(Integer good_id);
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

  /****
   * 处理miniCart(立即购买，和加入购物车功能)
   * @param integer
   * @param request
   * @return
   */
    String mincartGoodSrevice(Integer integer, HttpServletRequest request);

  /***
   * 页面刷新时，更新mini购物车信息
   * @param session
   * @return
   */
    String mincartGoodSrevice(HttpSession session);

    Integer getTotalPrice(HttpServletRequest request);

  /**
   * 获取当前插入购物车的所有商品名称 用于在页面显示
   * @param httpSession
   * @return good集合
   */
  List<Good> packagingGood(HttpSession httpSession);

}
