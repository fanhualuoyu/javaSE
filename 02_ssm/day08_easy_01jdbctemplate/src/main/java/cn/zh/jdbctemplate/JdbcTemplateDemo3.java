package cn.zh.jdbctemplate;

import cn.zh.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcTemplate的crud操作
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {

        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into account2(name,money) values(?,?)","ddd",1000f);
        //更新
//        jt.update("update account2 set name = ?,money = ? where id = ?","ddd",4567,7);
        //删除
//          jt.update("delete from account2 where id = ?",8);
        //查询所有
//          List<Account> accounts = jt.query("select * from account2 where money > ?",new AccountRowMapper(),800f);
//        List<Account> accounts = jt.query("select * from account2 where money > ?",new BeanPropertyRowMapper<Account>(Account.class),800f);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> accounts = jt.query("select * from account2 where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        //查询返回一列一行（使用聚合函数，但不加group by子句）
        int count = jt.queryForObject("select count(*) from account2 where money>?",Integer.class,800f);
        System.out.println(count);
    }

}

class AccountRowMapper implements RowMapper<Account>{
    /**
     * 将结果集中的数据封装到Account中，然后由spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}