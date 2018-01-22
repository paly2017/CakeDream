package com.cake.contorllers;

import com.cake.pojo.Good;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import com.cake.uilt.Uilt;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/***
 * Ajax请求控制器
 */
@Controller
@ResponseBody
@RequestMapping(value = "" ,method = RequestMethod.POST,produces = "text/jsp;charset=UTF-8")
public class ReqAjax {
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
    public String getGood(@RequestParam("goodid")String goodID){
        System.out.println("goodId = [" + goodID + "]");
        return  goodService.getOneGood(Integer.parseInt(goodID));
    }

}
