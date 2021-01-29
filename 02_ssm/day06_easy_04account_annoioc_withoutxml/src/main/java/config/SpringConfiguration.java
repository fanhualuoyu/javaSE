package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 * Configuration
 *      作用：指定当前类是一个配置类
 * ComponentScan
 *      作用：通过注解指定spring在创建容器时要扫描的包
 *      属性：
 *          value：它和basePackages的作用是一样的，都是用于指定创建容器时要扫描的包
 *                  我们使用此注解就等同于在xml中配置了：
 *                  <context:component-scan base-package="cn.zh"></context:component-scan>
 *
 * Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性：
 *          name:用于指定bean的id。当不写时，默认值时当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法中有参数，spring框架会去容器中查找有没有可用的bean对象
 *          查找的方式和Autowired注解的作用时一样的。
 *
 * Import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value:用于指定其他配置类的字节码
 *              当我们使用Import的注解之后，有Import注解的类就父配置类，而导入的都是子配置类
 *
 * PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value:指定文件的名称和路径
 *              关键字：classpath,表示类路径下
 */
@Configuration
@ComponentScan(basePackages = "cn.zh")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    /**
     * 用来创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

}
