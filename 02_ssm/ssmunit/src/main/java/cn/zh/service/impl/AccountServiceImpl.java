package cn.zh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.dao.AccountDao;
import cn.zh.domain.Account;
import cn.zh.service.AccountService;

/**
 * 业务层
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountDao accountDao;

  @Override
  public List<Account> findAll() {
    System.out.println("Service___findAll......");
    return accountDao.findAll();
  }

  @Override
  public void saveAccount(Account account) {
    accountDao.saveAccount(account);
  }

  
}