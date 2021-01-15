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

        /**
         * final关键字：
         *  修饰类：当前这个类不能有任何的子类
         *  修饰方法：这个方法时最终方法，不能被覆盖重写
         *  修饰局部变量：这个变量不能进行改变，一次赋值，终生不变
         *      对于基本类型来说，不可变说的是变量当中的数据不可改变
         *      对于引用类型来说，不可变说的是变量当中的地址值不可改变
         *  修饰成员变量：使用final后要手动赋值，不会再给默认值了
         */

        /**
         * 权限修饰符：       public  >  protected  >  (default)  >  private
         *   同一个类         YES           YES         YES            YES
         *   同一个包         YES           YES         YES             NO
         *   不同包子类       YES           YES          NO             NO
         *   不同包非子类     YES            NO          NO             NO
         */

        /**
         * String与StringBuilder:
         *   String：字符串是常量，它们的值创建之后不能更改，底层是一个被final修饰的数组，不能改变，是一个常量
         *   StringBuilder：字符串缓冲区，可以提高字符串的操作效率(看成是一个长度可以变换的数组)
         */

        /**
         * Collection接口：所有单列表集合中共性的方法
         *     没有带索引的方法
         * List接口：
         *      有序的集合
         *      允许存储重复的元素
         *      有索引，可以使用普通的for循环
         * Set接口：
         *      不允许存储重复元素
         *      没有索引，不能使用普通的for循环遍历
         */

        /**
         * 泛型接口：
         *  1. 定义接口的实现类，实现接口，指定接口的泛型
         *      public interface Iterator<E>{E.next()}
         *      public final class Scanner implements Iterator<String>{}
         *  2. 接口使用什么泛型，实现类就使用什么泛型，类跟着接口走
         *      public interface list<E>{boolean add(E e); E get(int index);}
         *      public class ArrayList<E> implements list<E> {public boolean add(E e){}; public E get(int index);}
         */

        /**
         *  throw关键字后边创建的是RuntimeException或者是RuntimeException的子类对象，我们可以不处理，默认交给JVM处理
         *  throw关键字后边创建的编译异常(写代码的时候报错)，我们必须处理这个异常，要么throws，要么try..catch
         *  子父类异常：
         *      如果父类抛出了多个异常，子类重写方法时，抛出和父类相同的异常或者是父类异常的子类或者不抛出异常。
         *      父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出。
         *      父类没有抛出异常，子类重写方法也不能抛出异常。
         */

        /**
         * 写入数据的原理：
         *  Java程序->JVM->OS->OS调用写数据方法->把数据写入到文件中
         * 读取数据的原理：
         *  Java程序->JVM->OS->OS调用读数据方法->读取文件
         */

        /**
         * 序列化与反序列化：保存对象和读取对象使用的
         * transient关键字：瞬态关键字。修饰变量可以使变量不被序列化
         */

        /**
         * 函数式接口：有且只有一个抽象方法的接口。接口中可以包含其他的方法(默认，静态，私有)
         * @FunctionalInterface 注解用来表明是函数式接口
         */

        /**
         * 注解
         *  本质：本质上就是一个接口，该接口默认继承Annotation接口
         *      public interface MyAnno extends java.lang.annotation.Annotation{}
         *  属性：接口中的抽象方法
         *      要求：
         *          1.属性的返回值类型有下列取值
         *              * 基本数据类型
         *              * String
         *              * 枚举
         *              * 注解
         *              * 以上类型的数组
         *          2.定义了属性，在使用时需要给属性赋值
         *              * 可以使用default关键字默认初始化值
         *              * 如果只有一个属性需要赋值，并且属性名称是value，则value可以省略
         *              * 数组赋值使用{}。如果只有一个值则{}可以省略
         *  元注解：用于描述注解的注解
         *          * @Target:描述注解能够作用的位置
         *          * @Retention：描述注解被保留的阶段
         *          * @Documented：描述注解是否被抽取到api文档中
         *          * @Inherited：描述注解是否被子类继承
         */
    }
}
