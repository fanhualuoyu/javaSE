package cn.zh.service.impl;

import cn.zh.dao.IAccountDao;
import cn.zh.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

}
