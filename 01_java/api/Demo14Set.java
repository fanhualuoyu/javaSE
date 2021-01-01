package api;

import domain.Demo14HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

//Set类:不允许重复，没有索引。原理：hasCode()和equals
public class Demo14Set {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }

    //HashSet集合：是一个无序的集合，存储和取出的元素顺序可能不一致；查询的速度块。
    public static void demo1() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            System.out.println(next);
        }
        System.out.println("================");
        for (Integer integer : set) {
            System.out.println(integer);
        }
        System.out.println("================");
    }

    //自定义HashSet的类型
    public static void demo2() {
        HashSet<Demo14HashSet> hashSet = new HashSet<>();
        Demo14HashSet p1 = new Demo14HashSet("张三",18);
        Demo14HashSet p2 = new Demo14HashSet("张三",18);
        Demo14HashSet p3 = new Demo14HashSet("李四",20);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1 == p2); //false
        System.out.println(p1.equals(p2)); //true
        System.out.println("================");
    }

    //LinkedHashSet：哈希表+链表,有序不允许重复
    public static void demo3() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        linkedHashSet.add("c");
        linkedHashSet.add("a");
    }
}
