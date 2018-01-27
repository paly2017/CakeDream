package com.cake.contorllers;

import com.cake.pojo.Type;
import com.cake.service.Impl.TypeServiceImpl;
import com.google.common.base.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private TypeServiceImpl typeService;
    @RequestMapping("/getadminType")
    public ModelAndView adminMsgGoodsType(ModelAndView modelAndView){
        List<Type> typeList = typeService.selectAllItemType();
        Optional.of(typeList);
        modelAndView.addObject("typegood",typeList);
        modelAndView.setViewName("admin/type_list");
        return modelAndView;
    }
}
