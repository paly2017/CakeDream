package com.cake.contorllers;

import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
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
}
