package cn.zh.service.impl;

import cn.zh.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了......");
    }

    public void init(){
        System.out.println("对象初始化了.........");
    }

    public void destroy(){
        System.out.println("对象销毁了...........");
    }
}
