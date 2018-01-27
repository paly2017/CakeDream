package com.cake.contorllers;

import com.cake.pojo.Type;
import com.cake.service.Impl.TypeServiceImpl;
import com.cake.uilt.Uilt;
import com.google.common.base.Optional;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TypeController {
    @Autowired
    private TypeServiceImpl typeService;

    /***
     * admin后台管理界面，显示商品类型
     */
    @RequestMapping("/getadminType")
    public ModelAndView adminMsgGoodsType(ModelAndView modelAndView){
        List<Type> typeList = typeService.selectAllItemType();
        Optional.of(typeList);
        modelAndView.addObject("typegood",typeList);
        modelAndView.setViewName("admin/type_list");
        return modelAndView;
    }
    @RequestMapping("/addtype")
    public ModelAndView addGoodType(ModelAndView modelAndView,
                                    @RequestParam("type.name")String typeNmae){
        System.out.println("modelAndView = [" + modelAndView + "], typeNmae = [" + typeNmae + "]");
        Optional.of(typeNmae);
        Type type = new Type();
        type.setName(typeNmae);
        List<Type> typeList=null;
        modelAndView.setViewName("admin/type_list");
        if (typeService.addGoodType(type)){
        }
        typeList = typeService.selectAllItemType();
        modelAndView.addObject("typegood",typeList);
        return modelAndView;

    }
    @RequestMapping("/changetype")
    public ModelAndView changeType(@RequestParam("type.name") String name,
                                   ModelAndView modelAndView,
                                   HttpServletRequest request){
        Integer integer = (Integer) request.getSession().getAttribute("typeid");
        if (typeService.changeTypeService(integer,name)){
           return adminMsgGoodsType(modelAndView);
        }
        return null;
    }

    /***
     * 类型删除
     * @param typeId
     * @return
     */
    @PostMapping("/deteleType")
    @ResponseBody
    public String deteleType(@RequestParam("deleteTypeId") Integer typeId){
        if (typeService.deteleTypeService(typeId)){
           List<Type> typeList =  typeService.selectAllItemType();
            return Uilt.getGsonToString(typeList);
        }
        return "no";
    }

    /***
     * 页面跳转
     * @return
     */
    @RequestMapping("/typeedit")
    public String sendChangeType(HttpServletRequest request ,
                                 @RequestParam("typeId") Integer index){
        request.getSession().setAttribute("typeid",index);
        return "admin/type_edit";
    }
}
