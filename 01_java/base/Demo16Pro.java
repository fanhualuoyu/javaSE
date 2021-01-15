package base;

import java.lang.reflect.Method;

//注解的使用与解析
@inherit.Demo16Pro(className = "domain.Demo16ProDemo", methodName = "show")
public class Demo16Pro {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取字节码文件
        Class<Demo16Pro> proClass = Demo16Pro.class;
        //1.2获取上边的注解
        inherit.Demo16Pro an = proClass.getAnnotation(inherit.Demo16Pro.class);
        //1.3调用注解对象中的抽象方法
        String className = an.className();
        String methodName = an.methodName();
        //2.加载类进内存
        Class cls = Class.forName(className);
        //3.创建对象
        Object obj = cls.newInstance();
        //4.获取方法对象
        Method method = cls.getMethod(methodName);
        //5.执行方法
        method.invoke(obj);
    }
}
