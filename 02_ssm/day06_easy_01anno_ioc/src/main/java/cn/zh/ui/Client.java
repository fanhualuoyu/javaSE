package cn.zh.ui;

import cn.zh.dao.IAccountDao;
import cn.zh.service.IAccountService;
import cn.zh.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        System.out.println(as);

        IAccountDao ad = ac.getBean("accountDao",IAccountDao.class);
        System.out.println(ad);
    }

}
