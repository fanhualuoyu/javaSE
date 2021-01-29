package cn.zh.test;

import cn.zh.dao.IAccountDao;
import cn.zh.dao.IUserDao;
import cn.zh.domain.Account;
import cn.zh.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    /**
     * 初始化操作
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    /**
     * 关闭连接
     * @throws IOException
     */
    @After
    public void destroy() throws IOException {
        //提交事务
        sqlSession.commit();
        //关闭连接
        sqlSession.close();
        in.close();
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    /**
     * 查询所有账户同时包含用户名和地址
     */
    @Test
    public void testFindAllAccount(){
        List<AccountUser> allAccount = accountDao.findAllAccount();
        for (AccountUser accountUser : allAccount) {
            System.out.println(accountUser);
        }
    }
}
