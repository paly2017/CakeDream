package com.cake.contorllers;

import com.cake.pojo.Type;
import com.cake.service.Impl.TopServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import com.cake.uilt.Uilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class TopAjax {
    //service实现类作为属性注入
    @Autowired
    private TopServiceImpl topServiceImpl;
    @Autowired
    private TypeServiceImpl typeServiceImpl;

    //移除商品推荐
    @PostMapping("/remove")
    public String removeTop(@RequestParam("topType")Integer topType,
                            @RequestParam("goodId")Integer goodId){
        String status;
        //调用topMapper的修改tops表的字段
        Integer a= topServiceImpl.removeTops(topType,goodId);
        if(a>0){
            status="success";
        }else{
            status="error";
        }
        return status;
    }
    @PostMapping("/add")
    @ResponseBody
    public String addTop(@RequestParam("topType")Integer topType,
                         @RequestParam("goodId")Integer goodId){
            //调用topMapper的修改tops表的字段
        Integer a= topServiceImpl.addTops(topType,goodId);
        String status;
        if(a>0){
            status="success";
        }else{
            status="error";
        }
         return status;
    }
    //查询所有类目
    @PostMapping("/getType")
    public String getType(){
        List<Type>type=typeServiceImpl.selectAllItemType();
        return Uilt.getGsonToString(type);
    }
}
