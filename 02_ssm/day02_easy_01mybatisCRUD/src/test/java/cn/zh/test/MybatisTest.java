package cn.zh.test;

import cn.zh.dao.IUserDao;
import cn.zh.domain.DoubleUser;
import cn.zh.domain.QueryVo;
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
    private SqlSession sqlSession;
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
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
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
        user.setUsername("王二");
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

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     *数据库和Bean不匹配时查询所有
     * @throws IOException
     */
    @Test
    public void testFindAllUser() throws IOException {
        List<DoubleUser> doubleUsers= userDao.findAllUser();
        for (DoubleUser doubleUser : doubleUsers) {
            System.out.println(doubleUser);
        }
    }
}
