package cn.zh.controller;

import cn.zh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把msg=美美存入到session域对中
public class AnnoController {
    /**
     * 前台内容：
     * <a href="anno/testRequestParam?name=hehe">RequestParam</a>
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了。。。。。");
        return "success";
    }

    /**
     * 前台内容：
     *     <form action="anno/testRequestBody" method="post">
     *       用户姓名：<input type="text" name="username"><br>
     *       用户年龄：<input type="text" name="age"><br>
     *       <input type="submit" value="提交">
     *     </form>
     * 
     * 获取请求体
     * @param body
     * @return
     */
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    /**
     * 前台内容
     * <a href="anno/testPathVariable/10">testRequestParam</a>
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{sid}",method = RequestMethod.POST)
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println(id);
        return "success";
    }

    /**
     * 前台内容
     * <a href="anno/testRequestHeader">testRequestHeader</a>
     * 获取请求头
     * @param header
     * @return
     */
    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }

    /**
     * 前台内容
     * <a href="anno/testCookieValue">testCookieValue</a>
     * 获取Cookie的值
     * @param cookieValue
     * @return
     */
    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * 前台内容：
     *     <form action="anno/testModelAttribute" method="post">
     *       用户姓名：<input type="text" name="uname"><br>
     *       用户年龄：<input type="text" name="age"><br>
     *       <input type="submit" value="提交">
     *     </form>
     * ModelAttribute注解
     * @return
     */
    @RequestMapping(value = "/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了.........");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法会先执行
     */
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了..........");
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }

    /**
     * 前台内容
     * <a href="anno/testSessionAttributes">SessionAttributes</a>
     * SessionAttributes的注解
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...........");
        model.addAttribute("msg","cc");
        return "success";
    }

    /**
     * 前台内容
     * <a href="anno/getSessionAttributes">getSessionAttributes</a>
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("testSessionAttributes...........");
        Model msg = (Model) modelMap.get("msg");
        return "success";
    }

    /**
     * 前台内容
     *  <a href="anno/delSessionAttributes">delSessionAttributes</a>
     * @param status
     * @return
     */
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("testSessionAttributes...........");
        status.setComplete();
        return "success";
    }

}
