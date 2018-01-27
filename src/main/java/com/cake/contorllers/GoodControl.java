package com.cake.contorllers;
import com.cake.pojo.Good;
import com.cake.pojo.Top;
import com.cake.pojo.Type;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TopServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import com.cake.uilt.GetUploadObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class GoodControl {
    @Autowired
   private GoodServiceImpl goodServiceImpl;
    @Autowired
    private TopServiceImpl topServiceImpl;
    @Autowired
    private TypeServiceImpl typeServiceImpl;

    //查出所有商品推荐显示在所有商品页面
    @RequestMapping("/allGood")
    public ModelAndView selectAllGood(@RequestParam(value ="pageNum",required = false)Integer pageNum,
                                     ModelAndView modelAndView,
                                     HttpServletRequest request){
        //查出商品总数
       List<Good> all =goodServiceImpl.selectAllGood();
       Integer sum=all.size();
        //页面容量
        Integer pageSize=4;
        //总共多少页
        Integer pageCount =sum%4==0?sum/4:sum/4+1;
        //判断当前页数是否为0
        if(pageNum==null){
            pageNum=1;
        }else if(pageNum<=0){
            pageNum=1;
        }else if(pageNum>pageCount){
            pageNum=pageCount;
        }
        Integer fromIndex =pageSize*(pageNum-1);
        //分页查询
        Integer flag=1;//遍历Good
        request.getSession().setAttribute("good",flag);
        List<Good> limitList= goodServiceImpl.selectLimitGood(fromIndex,pageSize);
        //循环遍历集合--查商品推荐集合、商品类型
        for (Good good:limitList) {
            //查出每一个商品对应的推荐类型集合，一盒商品对应多个推荐类型
            List<Top> topList =topServiceImpl.selectTopByGoodId(good.getId());
            //循环遍历集合，设置商品的推荐属性
            for (Top top:topList) {
                if(top.getType()==1){//如果商品推荐表的类型为1、条幅，为2、热销3、新品
                    good.setTopScroll(true);
                }else if (top.getType()==2){
                    good.setTopHotSale(true);
                }else{
                    good.setTopNewgood(true);
                }
            }
            good.setType(typeServiceImpl.selectTpyeById(good.getTypeId()));
        }
        modelAndView.addObject("goodList",limitList);
        //将页数也要放入ModelAndView
        modelAndView.addObject("pageNum",pageNum);
        modelAndView.addObject("pageCount",pageCount);
        modelAndView.setViewName("admin/good_list");
        return modelAndView;
    }
    //跳到商品添加页面
    @RequestMapping("/goodAdd")
    public String jumpAddGood(){
        return "admin/good_add";
    }

    @RequestMapping("/goosSave")
    public ModelAndView MutilForm(HttpServletRequest request ,ModelAndView modelAndView){
       //调用工具包中，根据表单提交的数据封装的对象
       Good good= GetUploadObj.GetUpdateGood(request);
        System.out.println(good.toString());
       //调用添加商品的方法
        goodServiceImpl.addGood(good.getName(),good.getCover(),good.getImage1(),good.getImage2(),good.getPrice(),good.getIntro(),good.getStock(),good.getTypeId());
        modelAndView.setViewName("admin/good_add");
        return modelAndView;
    }

//跳到商品编辑页
    @RequestMapping("/edit")
    public ModelAndView jumpEdit(@RequestParam("goodId")Integer goodId,ModelAndView modelAndView){
        //根据商品id查询商品信息，返回商品编辑页面
      Good good=  goodServiceImpl.slectGoodByGoodId(goodId);
        modelAndView.addObject("oneGood",good);
        modelAndView.setViewName("admin/good_edit");
        return modelAndView;
    }
}
