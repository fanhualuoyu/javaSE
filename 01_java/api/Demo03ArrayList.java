package api;

import java.util.ArrayList;

//ArrayList类
public class Demo03ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        //添加元素:public boolean add(E e)
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println("list添加后：" + list);

        //获取元素:public E get(int index)
        String str = list.get(1);
        System.out.println("list获取元素：" + str);

        //删除元素:public E remove(int index)
        str = list.remove(2);
        System.out.println("list删除元素：" + str);

        //获取长度:public int size()
        int len = list.size();
        System.out.println("list长度：" + len);
        System.out.println("test");
    }
}
