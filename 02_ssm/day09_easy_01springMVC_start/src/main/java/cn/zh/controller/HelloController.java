package cn.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello stringMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * method:接收什么类型的请求
     * params:接收的参数中要有指定的属性
     * headers:必须包含对应的请求头
     * @return
     */
    /**
     * a href="user/testRequestMapping">入门程序</a>
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",method = RequestMethod.GET,params = {"username"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解....");
        return "success";
    }

}
