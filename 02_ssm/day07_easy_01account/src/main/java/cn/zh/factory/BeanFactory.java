package cn.zh.factory;

import cn.zh.domain.Account;
import cn.zh.service.IAccountService;
import cn.zh.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;


    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public IAccountService getAccountService(){
       return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {                    
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        Object rtValue = null;
                        try{
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            method.invoke(accountService,objects);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        }catch (Exception e){
                            //5.回滚操作
                            txManager.rollback();
                            throw  new RuntimeException(e);
                        }finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
