package base;

import inherit.Demo03ExtendsZi;

// 继承
public class Demo03Extends {
    /**
     * 在父子类的继承关系中，如果成员变量重名，则创建子类对象时，访问有两种方式：
     *  直接通过子类对象访问成员变量：
     *      等号左边是谁，就优先用谁，没有则向上找
     *  间接通过成员方法访问成员变量：
     * 在父子类的继承关系中，创建子类对象，访问成员方法的规则：
     *  创建对象是谁，就优先用谁，如果没有则向上找
     */
    public static void main(String[] args) {
        Demo03ExtendsZi zi = new Demo03ExtendsZi();

        //重名变量问题
        System.out.println(zi.num);
        System.out.println("===========");

        //重名方法
        zi.method();
        System.out.println("===========");
    }

}
