package cn.zh.service.impl;

import cn.zh.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("保存了。。。。。。。");
    }

    public void updateAccount(int i) {
        System.out.println("更新了。。。。。。。");
    }

    public int deleteAccount() {
        System.out.println("删除了。。。。。。。。");
        return 0;
    }
}
