package cn.zh.dao;

import cn.zh.domain.Account;
import cn.zh.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查找所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
