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


    }
}
