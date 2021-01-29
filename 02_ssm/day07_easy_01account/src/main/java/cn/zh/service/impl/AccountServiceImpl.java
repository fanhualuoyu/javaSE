package cn.zh.service.impl;

import cn.zh.dao.IAccountDao;
import cn.zh.domain.Account;
import cn.zh.service.IAccountService;
import cn.zh.utils.TransactionManager;

import java.util.List;

/**
 *
 *
 * 账户控制在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
            return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);
    }

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
                //1.根据名称查询转出账户
                Account source = accountDao.findAccountByName(sourceName);
                //2.根据名称查询转入账户
                Account target = accountDao.findAccountByName(targetName);
                //3.转出账户减钱
                source.setMoney(source.getMoney()-money);
                //4.转入账户加钱
                target.setMoney(target.getMoney()+money);
                //5.更新转出账户
                accountDao.updateAccount(source);
                //6.更新转入账户
                accountDao.updateAccount(target);

    }
}
