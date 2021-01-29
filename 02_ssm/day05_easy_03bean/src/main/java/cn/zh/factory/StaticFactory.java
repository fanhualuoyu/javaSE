package cn.zh.factory;

import cn.zh.service.IAccountService;
import cn.zh.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
