package com.springMVC0202.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author LM_Code
 * @create 2019-04-09-16:06
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("test执行。。。。。");
        return "success";
    }

    /**
     * 传统方式
     * 上传文件
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传中。。。");
        //使用fileupload上传文件
        //确定上传文件所在的
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断目录是否存在
        File file = new File(path);
        if(!file.exists()){
            System.out.println("目录不存在");
            file.mkdirs();
        }
        //解析request对象，获得上传文件项
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历
        for (FileItem item : fileItems) {
            //判断当前item对象，是否是上传文件项
            if(item.isFormField()){
                //是普通表单项
            }else {
                //是上传文件项
                //获得上传文件的名称
                String fileName = item.getName();
                //设置文件名唯一值
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                fileName = uuid + "_" + fileName;
                //完成上传文件
                item.write(new File(path, fileName));//在项目下写入文件（path/文件名）
                System.out.println("已写入文件");
//                item.delete();//删除临时文件
                System.out.println("成功");
            }
        }
        return "success";
    }

    /**
     * springMVC文件上传
     * @return
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("SpringMVC文件上传中。。。");
        //使用fileupload上传文件
        //确定上传文件所在的
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断目录是否存在
        File file = new File(path);
        if(!file.exists()){
            System.out.println("目录不存在");
            file.mkdirs();
        }
        //名字设置为唯一
        String fileName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileName = uuid + "_" + fileName;
        //文件上传
        upload.transferTo(new File(path, fileName));
        return "success";
    }
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws IOException {
        System.out.println("跨服务器SpringMVC文件上传中。。。");
        //定义上传文件服务器路径
        String path = "http://101.132.78.78:8080/fileserver/uploads";

        String fileName = upload.getOriginalFilename();
        //名字设置为唯一
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileName = uuid + "_" + fileName;
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource resource = client.resource(path + fileName);
        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }
}
