package api;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

//LinkedList类：查询快，增删慢
public class Demo13LinkList {
    public static void main(String[] args) {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("张三");
        linked.add("李四");
        linked.add("王二");

        //public void addFirst(E e):将指定元素插入此列表的开头
        linked.addFirst("First");
        System.out.println(linked);
        System.out.println("=======================");

        //public void push(E e)：等同于addFirst
        linked.push("pushFirst");
        System.out.println(linked);
        System.out.println("=======================");

        //public void addLast(E e): 将指定元素添加到此列表的结尾
        linked.addLast("Last");
        System.out.println(linked);
        System.out.println("=======================");

        //public E getFirst(): 获取首元素
        String first = linked.getFirst();
        System.out.println(first);
        System.out.println("=======================");

        //public E getLast(): 获取尾元素
        String last = linked.getLast();
        System.out.println(last);
        System.out.println("=======================");

        //public E removeFirst()：移除第一个元素
        String re = linked.removeFirst();
        System.out.println(re);
        System.out.println("=======================");

        //public E pop()  【public E removeLast()】:移除最后一个元素
        String removeLast = linked.removeLast();
        System.out.println(removeLast);
        System.out.println("=======================");

        System.out.println(linked.isEmpty());
    }
}
