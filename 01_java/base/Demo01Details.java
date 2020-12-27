package base;

public class Demo01Details {
    public static void main(String[] args) {
        short a = 5;
        short b = 8;
        // short + short --> int + int --> int
        // short result = a + b; //错误写法
        int result = a + b;
        System.out.println(result);

        // switch后面小括号当中只能是下列数据类型：
        // 基本数据类型：byte/short/char/int
        // 引用数据类型：String字符串、enum枚举

        /**
         * Java的内存划分的5部分：
         *  1. 栈(Stack)：存放的都是方法中的局部变量，方法的运行一定要在栈当中。
         *  2. 堆(Heap)：凡是new出来的东西，都在堆当中
         *  3. 方法区(Method Area)：存储.class相关信息，包含方法的信息
         *  4. 本地方法栈(Native Method Stack)：与操作系统相关
         *  5. 寄存器(pc Register)：与CPU相关
         */

        // 使用对象作为函数的返回值返回的是地址值

        // 对于基本类型当中的boolean的值，Getter方法一定要写成isXxx的形式，而setXxx规则不变

        //泛型只能是引用类型，不能是基本类型

        /**
         * 基本类型     包装类
         * byte         Byte
         * short        Short
         * int          Integer
         * long         Long
         * float        Float
         * double       Double
         * char         Character
         * boolean      Boolean
         */

        /**
         * 字符串的特点；
         *  字符串的内容永不改变
         *  字符串是可以共享使用的
         *  字符串的效果上相当于char[]字符数组，但是底层原理是byte[]字节数组
         */

        //String的split方法参数是一个正则表达式

        /**
         * 静态方法：
         *  根据类名称访问静态成员变量的时候，
         *  全程和对象没有关系，只和类有关系
         */

        /**
         * 在父子类的继承关系中，如果成员变量重名，则创建子类对象时，访问有两种方式：
         *  直接通过子类对象访问成员变量：
         *      等号左边是谁，就优先用谁，没有则向上找
         *  间接通过成员方法访问成员变量
         * 在父子类的继承关系中，创建子类对象，访问成员方法的规则：
         *  创建对象是谁，就优先用谁，如果没有则向上找
         */


        /**
         * 接口：
         *  接口当中的抽象方法，修饰符必须是两个固定的关键字：public abstract(可以选择性的省略)
         * 接口中的内容：
         *  常量，抽象方法，默认方法，静态方法，私有方法
         * 注意事项：
         *  接口是没有静态代码块或者构造方法的
         *  一个类可以实现多个接口
         *  多个接口的方法重名则只需要重写一个方法即可
         *  多个接口存在重复的默认方法，那么实现类一定要对冲突的默认方法进行重写
         *  类的直接父类的方法和接口当中的默认方法产生了冲突，优先用父类的方法
         */

        /**
         * 多态：
         * 格式：
         *      父类名称 对象名 = new 子类名称()
         *      接口名称 对象名 = new 实现类名称()
         */
    }
}
