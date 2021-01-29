package cn.zh.controller;

import cn.zh.domain.Account;
import cn.zh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 前台页面
     * <a href="param/testParam?username=hehe">请求参数绑定</a>
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("执行了....");
        System.out.println("用户名："+username);
        return "success";
    }

    /**
     *  private String username;
        private String password;
        private Double money;
        private User user;
     * 前台页面
     * <form action="param/saveAccount" method="post">
            姓名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            金额：<input type="text" name="money"><br>
            用户姓名：<input type="text" name="user.uname"><br>
            用户年龄：<input type="text" name="user.age"><br>
            <input type="submit" value="提交">
       </form>

       private String username;
       private String password;
       private Double money;
       private List<User> list;
       private Map<String,User> map;
       <form action="param/saveAccount" method="post">
            姓名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            金额：<input type="text" name="money"><br>
            用户姓名：<input type="text" name="list[0].uname"><br>
            用户年龄：<input type="text" name="list[0].age"><br>
            用户姓名：<input type="text" name="map['one'].uname"><br>
            用户年龄：<input type="text" name="map['one'].age"><br>
            <input type="submit" value="提交">
       </form>
     * 请求参数绑定把数据封装到JavaBean的类当中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    /**
     * 前台页面
     * <form action="param/saveUser" method="post">
            用户姓名：<input type="text" name="uname"><br>
            用户年龄：<input type="text" name="age"><br>
            用户生日：<input type="text" name="date"><br>
            <input type="submit" value="提交">
       </form>
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 前台页面
     * <a href="param/testServlet">Servlet原生的api</a>
     * 获取原生的Servlet的api
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        return "success";
    }



}
