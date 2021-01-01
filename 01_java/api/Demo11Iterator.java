package api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//迭代器
public class Demo11Iterator {
    public static void main(String[] args) {
        /**
         *  对Collection进行迭代的。
         * 迭代：在取元素之前先判断集合中有没有元素，如果有，就把这个元素取出来，
         *      继续再判断，如果还有就再取出来。一直把集合中的所有元素全部取出
         * 迭代器使用步骤：
         *  1.使用集合中的iterator()获取迭代器的实现类对象，使用Iterator接口来接收
         *  2.使用iterator接口中的方法hasNext判断有没有下一个元素
         *  3.使用iterator接口中的方法Next取出集合中的下一个元素
         */
        Collection<String> coll = new ArrayList<>();
        coll.add("张三");
        coll.add("王二");
        coll.add("李四");
        coll.add("麻子");
        Iterator<String> iterator = coll.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("=========================");

        /**
         * 增加for循环：内部原理是迭代器
         */
        for (String s : coll) {
            System.out.println(s);
        }
    }
}
