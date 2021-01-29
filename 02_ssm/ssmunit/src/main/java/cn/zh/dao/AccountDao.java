package cn.zh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.zh.domain.Account;
import jdk.jfr.Registered;

/**
 * 持久层
 */
@Registered
public interface AccountDao {

  /**
   * 查询所有
   * @return
   */
  @Select("select * from account")
  public List<Account> findAll();

  /**
   * 保存账户
   */
  @Insert("insert into account (name,money) values (#{name},#{money})")
  public void saveAccount(Account account);

}