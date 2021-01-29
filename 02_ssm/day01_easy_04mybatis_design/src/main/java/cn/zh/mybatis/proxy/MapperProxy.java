package cn.zh.mybatis.proxy;

import cn.zh.utils.Executor;
import cn.zh.utils.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String,Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对方法的增强
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className+"."+methodName;
        //4.获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5.判断是否有mapper
        if (mapper == null){
            throw  new IllegalArgumentException("传入的参数有误");
        }
       return new Executor().selectList(mapper,conn);
    }
}
