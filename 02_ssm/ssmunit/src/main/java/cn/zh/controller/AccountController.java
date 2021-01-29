package cn.zh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zh.service.AccountService;

/**
 * 表现层
 */
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {
  
  @Autowired
  private AccountService accountService;

  @RequestMapping("/findAll")
  public String findAll(){
    accountService.findAll();
    return "list";
  }

}