package api;

import java.util.ArrayList;
import java.util.Collection;

//Collection类
public class Demo10Collection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        //public boolean add(E e)：添加对象到当前集合
        boolean b1 = coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        System.out.println("b1: " + b1);
        System.out.println(coll);
        System.out.println("=======================");

        //public boolean remove(E e)：删除指定的元素
        boolean b2 = coll.remove("张三");
        System.out.println("b2: " + b2);
        System.out.println(coll);
        System.out.println("=======================");

        //public boolean contains(E e)：是否包含当前对象
        boolean b3 = coll.contains("王五");
        System.out.println("b3: " + b3);
        System.out.println("=======================");

        //public boolean isEmpty()：判断集合是否为空
        boolean b4 = coll.isEmpty();
        System.out.println("b4: " + b4);
        System.out.println("=======================");

        //public int size()：返回集合中元素的个数
        int size = coll.size();
        System.out.println("size: " + size);
        System.out.println("=======================");

        //public Object[] toArray()：把集合中的元素，存储到数组中
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("=======================");

        //public void clear()：清空所有元素，但不删除集合，集合还存在
        coll.clear();
        System.out.println(coll);
        System.out.println("=======================");
    }
}
