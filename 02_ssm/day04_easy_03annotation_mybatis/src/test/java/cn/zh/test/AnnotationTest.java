package cn.zh.test;

import cn.zh.dao.IUserDao;
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
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 保存用户
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("麻子");
        user.setAddress("上海");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }

    /**
     * 更新用户
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(8);
        user.setUsername("麻子(更新)");
        user.setAddress("上海");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void testDelete(){
        userDao.deleteUser(8);
    }

    /**
     * 查找一个用户
     */
    @Test
    public void testFindOne(){
        User user = userDao.findById(6);
        System.out.println(user);
    }

    /**
     * 根据用户名进行模糊查询
     */
    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查找总数
     */
    @Test
    public void testTotal(){
        int total = userDao.findTotalUser();
        System.out.println(total);
    }
}
