package cn.zh.controller;

import cn.zh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了........");

        User user = new User();
        user.setUsername("cc");
        user.setPassword("123");
        user.setAge(22);

        model.addAttribute("user",user);

        return "success";
    }

    /**
     * 无返回值
     * 请求转发一次请求，不用编写项目的名称
     * @param
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了........");
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);


        //response.sendRedirect(request.getContextPath()+"index.jsp");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好，hello");

        return;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();

        System.out.println("testModelAndView方法执行了........");

        User user = new User();
        user.setUsername("cc");
        user.setPassword("123");
        user.setAge(22);

        mv.addObject("user",user);
        mv.setViewName("success");

        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了........");


        //请求的转发
        //return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和相应
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println(user);
        //模拟查询数据库
        user.setUsername("ha");
        user.setAge(33);
        return user;
    }
}
