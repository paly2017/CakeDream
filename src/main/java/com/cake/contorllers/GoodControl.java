package com.cake.contorllers;
import com.cake.pojo.Good;
import com.cake.pojo.Top;
import com.cake.service.Impl.GoodServiceImpl;
import com.cake.service.Impl.TopServiceImpl;
import com.cake.service.Impl.TypeServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    public ModelAndView MutilForm(ModelAndView modelAndView){

        return modelAndView;
    }
}
