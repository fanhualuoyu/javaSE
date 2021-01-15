package base;

import domain.Demo15ReflectPerson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射：
 * 获取字节码文件的方法
 *      1.未加载进内存：Class.forName("全类名")：将字节码文件加载进内存
 *          * 多用于配置文件
 *      2.加载进内存后：类名.class：通过类名的属性class获取
 *          * 多用于参数的传递
 *      3.创建对象后：对象.getClass()
 *          * 多用于对象获取字节码文件对象
 */
public class Demo15Reflect {

    public static void main(String[] args) throws Exception {
        //获取字节码文件
        getClassMethod();
        System.out.println("==================");
        //获取成员变量
        getVarMethod();
        System.out.println("==================");
        //获取构造方法
        getConstructorMethod();
        System.out.println("==================");
        //获取成员方法
        getMethod();
        System.out.println("==================");
        //获取类名
        getClassNameMethod();
        System.out.println("==================");
    }

    //获取字节码文件
    private static void getClassMethod() throws Exception {
        //1.Class.forName()
        Class cls = Class.forName("domain.Demo15ReflectPerson");
        System.out.println(cls);
        //2.类名.class
        Class cls1 = Demo15ReflectPerson.class;
        System.out.println(cls1);
        //3.对象.getClass()
        Demo15ReflectPerson person = new Demo15ReflectPerson();
        Class cls2 = person.getClass();
        System.out.println(cls2);
        //比较三个
        System.out.println(cls==cls1);
        System.out.println(cls==cls2);
        System.out.println(cls1==cls2);
    }

    //获取成员变量
    private static void getVarMethod() throws Exception {
        Class personClass = Demo15ReflectPerson.class;
        //获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //获取指定名称的public成员变量
        Field a = personClass.getField("a");
        //获取a的值
        Demo15ReflectPerson person = new Demo15ReflectPerson();
        Object value = a.get(person);
        System.out.println(value);
        //设置a的值
        a.set(person,"张三");
        System.out.println(person);

        //获取所有的成员变量，不考虑修饰符
        Field[] fields1 = personClass.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
        //获取指定的成员变量，不考虑修饰符
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true); //暴力反射
        Object value2 = d.get(person);
        System.out.println(value2);

    }

    //获取构造方法
    private static void getConstructorMethod() throws Exception {
        Class personClass = Demo15ReflectPerson.class;
        //还有一些方法，同上边的获取成员变量
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //构造器用来创建对象的
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);

        //空参构造对象
        Object person1 = personClass.newInstance();
        System.out.println(person1);
    }

    //获取成员方法
    private static void getMethod() throws Exception {
        Class personClass = Demo15ReflectPerson.class;
        //方法还是同上
        Method eat_method = personClass.getMethod("eat");
        Demo15ReflectPerson person = new Demo15ReflectPerson();
        eat_method.invoke(person);

        Method eat_method1 = personClass.getMethod("eat", String.class);
        eat_method1.invoke(person,"饭");

        //获取所有的Public方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            //获取方法名
            String name = method.getName();
            System.out.println(name);
        }
    }

    //获取类名
    private static void getClassNameMethod() throws Exception {
        Class personClass = Demo15ReflectPerson.class;
        //获取类名
        String name = personClass.getName();
        System.out.println(name);
    }

}
