package base;

import domain.Demo02StaticStudent;

// static关键字
public class Demo02Static {

    //静态代码块:当第一次用到该类时代码块执行唯一的一次，比构造方法先执行
    static{
        System.out.println("静态代码块执行");
    }

    public static void main(String[] args) {

        //使用了static关键字，那么这样的内容不再属于对象自己，而是属于类，所以凡是本类的对象，都共享同一份
        Demo02StaticStudent one = new Demo02StaticStudent("张三",18);
        one.room = "101教室";
        System.out.println(one + one.room);
        Demo02StaticStudent two = new Demo02StaticStudent("李四",19);
        System.out.println(two + two.room);
        System.out.println("=================");

        //一旦使用了static修饰成员方法，那么这就成为了静态方法。静态方法不属于对象，而是属于类。
        Demo02Static.myMethod();

        /**
         * 注意事项：
         *  1.静态不能直接访问非静态：因为内存中先有静态内容，后有的非静态内容
         *  2.静态方法中不能用this：this代表当前对象，但是静态和对象没有关系
         */

    }

    public static void myMethod(){
        System.out.println("static关键字修饰的方法");
    }
}
