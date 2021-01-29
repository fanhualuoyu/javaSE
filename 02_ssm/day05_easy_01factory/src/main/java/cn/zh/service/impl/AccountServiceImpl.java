package cn.zh.service.impl;

import cn.zh.dao.IAccountDao;
import cn.zh.dao.impl.AccountDaoImpl;
import cn.zh.factory.BeanFactory;
import cn.zh.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

}
