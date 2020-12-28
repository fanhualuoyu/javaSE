package base;

import domain.Demo07ObjectPerson;

/**
 * Object类：所有类的根类
 */
public class Demo07Object {

    public static void main(String[] args) {
        Demo07ObjectPerson person = new Demo07ObjectPerson("张三",18);
        //toString方法
        String str = person.toString();
        //输出的地址值
        System.out.println(str);
        //直接打印对象的名字，其实调用的是toString方法
        System.out.println(person);

        //equals方法:默认情况下：(基本数据类型比较值，引用数据类型比较地址值)
        Demo07ObjectPerson person1 = new Demo07ObjectPerson("李四",18);
        Demo07ObjectPerson person2 = new Demo07ObjectPerson("李四",18);
        boolean b = person1.equals(person2);
        System.out.println(b);
    }
}
