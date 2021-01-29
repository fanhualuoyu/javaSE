package cn.zh.service.impl;

import cn.zh.dao.IAccountDao;
import cn.zh.domain.Account;
import cn.zh.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 * 账户控制在业务层
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public Account findAccountById(Integer accountId) {
            return accountDao.findAccountById(accountId);
    }

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = false)
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
                int i=1/0;
                //5.更新转出账户
                accountDao.updateAccount(source);
                //6.更新转入账户
                accountDao.updateAccount(target);

    }
}
