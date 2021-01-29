package cn.zh.test;

import cn.zh.dao.IUserDao;
import cn.zh.dao.impl.UserDaoImpl;
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

public class MybatisTest {
    private InputStream in;
    private IUserDao userDao;

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
        //3.使用工厂对象创建dao对象
        userDao = new UserDaoImpl(factory);

    }

    /**
     * 关闭连接
     * @throws IOException
     */
    @After
    public void destroy() throws IOException {
        in.close();
    }
    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws IOException {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存用户
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("daoImpl");
        user.setAddress("南京");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存前："+user);
        userDao.saveUser(user);
        System.out.println("保存后："+user);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(3);
        user.setUsername("王五");
        user.setAddress("焦作");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testDelete(){
        userDao.deleteUser(3);
    }

    /**
     * 根据id查询一个用户
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(4);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%李%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询所有的用户数量
     */
    @Test
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }

}
