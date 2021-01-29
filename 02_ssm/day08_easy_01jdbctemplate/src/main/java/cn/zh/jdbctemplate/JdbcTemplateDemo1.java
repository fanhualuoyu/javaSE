package cn.zh.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        //准备数据源,spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=GMT%2B8");
        ds.setUsername("root");
        ds.setPassword("root");
        //1.创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        //2，执行操作
        jt.execute("insert into account(name,money) values ('ddd',1000)");

    }

}
