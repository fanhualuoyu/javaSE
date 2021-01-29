package cn.zh.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {
    /**
     * 获取一个链接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        try{
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
