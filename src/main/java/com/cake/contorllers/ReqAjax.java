package com.cake.contorllers;

import com.cake.service.Impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    /***
     * 商品类型查询控制器，通过AJAX发送异步请求，
     * 返回商品类型的字符串
     * @return
     */
    @PostMapping("/classes")
    public String hell(){
        return typeService.selectAllType();
    }
}
