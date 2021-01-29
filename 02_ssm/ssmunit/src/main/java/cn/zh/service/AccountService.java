package cn.zh.service;

import java.util.List;

import cn.zh.domain.Account;

public interface AccountService {
  
  /**
   * 查询所有
   * @return
   */
  public List<Account> findAll();

  /**
   * 保存账户
   */
  public void saveAccount(Account account);

}