package com.cake.uilt;

import com.cake.pojo.Good;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;

//表单上传获取文件封装成实体类对象
public class GetUploadObj {
    public static Good GetUpdateGood(HttpServletRequest request) {
        //上传文件
        //创建商品对象封装表单元素
        Good good = new Good();
        //首先读取request请求，判断是否为多部分表单提交
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //判断--多部分表单上传
        if (isMultipart) {
            //创建FileItemFactory对象
            FileItemFactory factory = new DiskFileItemFactory();
            //创建ServletFileUpload对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解析request请求中的数据
            //处理表单请求
            List<FileItem> items;
            try {
                items = upload.parseRequest(new ServletRequestContext(request));
                //创建迭代器，进行集合遍历
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    //判断元素类型 是否普通表单元素
                    if (item.isFormField()) {
                        //根据表单name,设置对像属性
                        if (item.getFieldName().equals("goodName")) {
                            good.setName(item.getString("utf-8"));
                        } else if (item.getFieldName().equals("goodPrice")) {
                            good.setPrice(Integer.parseInt(item.getString()));
                        } else if (item.getFieldName().equals("goodIntro")) {
                            good.setIntro(item.getString("utf-8"));
                        } else if (item.getFieldName().equals("goodStock")) {
                            good.setStock(Integer.parseInt(item.getString()));
                        } else if (item.getFieldName().equals("goodTypeId")) {
                            good.setTypeId(Integer.parseInt(item.getString()));
                        }
                    } else {
                        //文件元素--读取文件的名称
                        String fieldName = item.getFieldName();
                        /* System.out.println("文件名：" + filename);*/
                        //上传路径
                        String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\temp\\upload\\";
                        if (fieldName.equals("cover")) {
                            //获取文件名
                            String fileName = item.getName();
                            //获取上传文件的名称，并根据名称创建一个新的file实例
                            File fullFile = new File(item.getName());
                            //从路径中提取文件名本身，并构建一个新的File实例
                            File saveFile = new File(path, fullFile.getName());
                            //写入文件，实现上
                            good.setCover("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\temp\\upload\\" + fileName+".jpg");
                        } else if (fieldName.equals("image1")) {
                            //获取文件名
                            String fileName = item.getName();
                            //获取上传文件的名称，并根据名称创建一个新的file实例
                            File fullFile = new File(item.getName());
                            //从路径中提取文件名本身，并构建一个新的File实例
                            File saveFile = new File(path, fullFile.getName());
                            //写入文件，实现上
                            good.setImage1("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\temp\\upload\\" + fileName+".jpg");
                        } else {
                            //获取文件名
                            String fileName = item.getName();
                            //获取上传文件的名称，并根据名称创建一个新的file实例
                            File fullFile = new File(item.getName());
                            //从路径中提取文件名本身，并构建一个新的File实例
                            File saveFile = new File(path, fullFile.getName());
                            //写入文件，实现上
                            good.setImage2("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\temp\\upload\\" + fileName+".jpg");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return good;
    }
}
