package cn.zh.test;

import cn.zh.dao.IUSerDao;
import cn.zh.domain.User;
import cn.zh.mybatis.SqlSession.SqlSession;
import cn.zh.mybatis.SqlSession.SqlSessionFactory;
import cn.zh.mybatis.SqlSession.SqlSessionFactoryBuilder;
import cn.zh.mybatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUSerDao userDao = session.getMapper(IUSerDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        in.close();
    }
}
