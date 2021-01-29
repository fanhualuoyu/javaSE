package cn.zh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zh.service.AccountService;

public class TestSpring {
  
  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    AccountService accountService = ac.getBean("accountService",AccountService.class);
    accountService.findAll();
  }

}