package cn.zh.dao;

import cn.zh.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);
}
