package cn.zh.ui;

import cn.zh.factory.BeanFactory;
import cn.zh.service.IAccountService;

/**
 * 模拟表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //AccountServiceImpl as = new AccountServiceImpl();
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }

}
