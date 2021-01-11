package api;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

//Properties extends Hashtable<K,V> implements Map<K,V>
public class Demo17Properties {
    public static void main(String[] args) throws IOException {
        //show01();

        //show02();

        show03();
    }

    private static void show01() {
        Properties prop = new Properties();
        prop.setProperty("zhangsan","1");
        prop.setProperty("lisi","2");
        prop.setProperty("wanger","3");
        Set<String> strings = prop.stringPropertyNames();
        for (String key : strings) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    //store方法：把集合中的临时数据，持久化写入到硬盘中存储
    private static void show02() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("zhangsan","1");
        prop.setProperty("lisi","2");
        prop.setProperty("wanger","3");
        //字符流
        FileWriter fw = new FileWriter("01_java\\file\\c.txt");
        prop.store(fw,"sava data");//注释
    }

    //load方法，把硬盘中保存的文件，读取到集合中使用
    private static void show03() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("01_java\\file\\c.txt"));
        Set<String> s = prop.stringPropertyNames();
        for (String s1 : s) {
            String property = prop.getProperty(s1);
            System.out.println(s1 + "=" + property);
        }
    }
}
