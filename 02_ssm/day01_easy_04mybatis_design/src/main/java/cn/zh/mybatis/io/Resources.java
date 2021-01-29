package cn.zh.mybatis.io;

import java.io.InputStream;

public class Resources {
    /**
     * 读取配置文件
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
