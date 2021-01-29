package cn.zh.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");

        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //解析request对象，获取文件上传
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断当前的item对象是否是上传文件项
            if (item.isFormField()){
                //普通项
            }else {
                //文件项
                //获取上传文件的名称
                String filename = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename= uuid+"_"+filename;
                //完成文件上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }

        return "success";
    }

    /**
     * spingMVC实现文件上传
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request,MultipartFile upload) throws IOException {//upload和表单中的name要一样
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename= uuid+"_"+filename;
        //完成上传
        upload.transferTo(new File(path,filename));

        return "success";
    }

    /**
     * 跨服务器上传
     * @param upload
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws IOException {//upload和表单中的name要一样
        //定义上传文件服务器的路径
        String path = "http://localhost:9090/uploads/";

        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename= uuid+"_"+filename;
        //完成上传
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
