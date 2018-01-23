package com.cake.contorllers;

import com.cake.pojo.MiniCart;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/***
 * Ajax请求控制器
 */
@Controller
@ResponseBody
@RequestMapping(value = "" ,method = RequestMethod.POST,produces = "text/jsp;charset=UTF-8")
public class ReqAjax {
    private List<Integer> integerList;
    //类型service
    @Autowired
     private TypeServiceImpl typeService;
    @Autowired
    private GoodServiceImpl goodService;
    /***
     * 商品类型查询控制器，通过AJAX发送异步请求，
     * 商品类型全查
     * 返回商品类型的字符串
     * @return
     */
    @PostMapping("/classes")
    public String goodsType(){
        return typeService.selectAllType();
    }
    @PostMapping("/getgood")
    public String getGood(@RequestParam("goodid")String goodID ,HttpServletRequest request){
        System.out.println("goodID = [" + goodID + "], request = [" + request + "]");
        return  goodService.mincartGoodSrevice(Integer.parseInt(goodID),request);
    }

    /****
     * Ajax 请求
     * Mini购物车，页面刷新时，查询购物车中所有商品
     * @param request
     * @return
     */
    @PostMapping("/newpageing")
    public String getGood(HttpServletRequest request){
        HttpSession session = request.getSession();
        return goodService.mincartGoodSrevice(session);
    }


    //加入购物车的方法
    @PostMapping("/addcart")
    public String addCart(@RequestParam("goodid") Integer goodId, HttpServletRequest request){
        String statue =null;
        //从session中取出购物车里的数据
        HttpSession httpSession= request.getSession();
        //取出session的属性
        List<MiniCart>  cartList =(  List<MiniCart> ) httpSession.getAttribute("minGoodsNum");
        //循环遍历集合
        for (MiniCart cart:cartList) {
            //找到该商品
            if(goodId==cart.getGood().getId()){
                //判断该商品库存--库存充足，购物车加1
                if( cart.getGood().getStock()>0){
                    cart.setCount(cart.getCount()+1);
                    statue= Uilt.getGsonToString(cart);
                }else{
                    //库存不足
                    statue= "empty";
                }
            }
        }
        return statue;
    }


    //减少商品的方法
    @PostMapping("/deccart")
    public String decCart(@RequestParam("goodid")Integer goodId, HttpServletRequest request){
        String statue =null;
        //从session中取出购物车里的数据
        HttpSession httpSession= request.getSession();
        //取出session的属性
        List<MiniCart>  cartList =(  List<MiniCart> ) httpSession.getAttribute("minGoodsNum");
        //循环遍历集合
        for (MiniCart cart:cartList) {
            //找到该商品
            if(goodId==cart.getGood().getId()){
                //判断商品数量大于0，减1
                if(cart.getCount()>0){
                    cart.setCount(cart.getCount()-1);
                    statue= Uilt.getGsonToString(cart);
                }else{
                    //直接删除该商品
                    deletCart(cart.getGood().getId(),request);
                    return "sussess";
                }
            }
        }//for
        return statue;
    }



    //删除商品的方法
    @PostMapping("/deletcart")
    public String deletCart(@RequestParam("goodid")Integer goodId, HttpServletRequest request){
        //从session中取出购物车里的数据
        HttpSession httpSession= request.getSession();
        //取出session的属性
        List<MiniCart>  cartList =(  List<MiniCart> ) httpSession.getAttribute("minGoodsNum");
        //循环遍历集合
        for (MiniCart cart:cartList) {
            //找到该商品
            if (goodId == cart.getGood().getId()) {
                //在集合中移除
                cartList.remove(cart);
            }
        }
        /*直接返回页面*/
        return "sussess";
    }


}
