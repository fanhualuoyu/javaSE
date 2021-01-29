package cn.zh.test;

import cn.zh.dao.IUserDao;
import cn.zh.domain.DoubleUser;
import cn.zh.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public  void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 查询所有用户
     */
    @Test
    public void testFindAll(){
        List<DoubleUser> users = userDao.findAll();
        for (DoubleUser user : users) {
            System.out.println("-----------每个用户的信息----------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }


}
