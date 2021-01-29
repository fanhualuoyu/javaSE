package cn.zh.controller;

import cn.zh.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController{

    @RequestMapping ("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了....");
        try {
            int i = 10/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("出现了错误.....");
        }
        return "success";
    }
}
