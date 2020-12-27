package inherit;

public interface Demo04Interface {

    //抽象方法
    public abstract void methodAbs();

    //默认方法:为了解决接口升级的问题
    public default void methodDefault(){
        System.out.println("这是接口的默认方法");
        methodPrivate();
    }

    //静态方法:不能通过接口实现类的对象来调用接口当中的静态方法
    public static void methodStatic(){
        System.out.println("这是接口的静态方法");
        methodStaticPrivate();
    }

    //私有方法：不让实现类使用
    //普通私有方法
    private void methodPrivate(){
        System.out.println("methodPrivate");
    }
    //静态私有方法
    private static void methodStaticPrivate(){
        System.out.println("methodStaticPrivate");
    }

    //接口中的常量定义
    public static final int NUM = 10;
}
