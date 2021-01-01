package api;

import domain.Demo10CollectionPerson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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

        //Collections
        demo();
    }


    //Collections
    public static void demo() {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c","d");
        System.out.println(list);
        Collections.shuffle(list); //打乱列表顺序
        System.out.println(list);
        System.out.println("=======================");

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        System.out.println(list1);
        Collections.sort(list1); //列表中的值排序，默认是升序
        System.out.println(list1);
        System.out.println("=======================");

        ArrayList<Demo10CollectionPerson> list2 = new ArrayList<>();
        list2.add(new Demo10CollectionPerson("张三",18));
        list2.add(new Demo10CollectionPerson("王五",20));
        list2.add(new Demo10CollectionPerson("李四",19));
        Collections.sort(list2);//需要实现Comparable接口
        Collections.sort(list2, new Comparator<Demo10CollectionPerson>() {
            @Override
            public int compare(Demo10CollectionPerson demo10CollectionPerson, Demo10CollectionPerson t1) {
                return demo10CollectionPerson.getAge() - t1.getAge();
            }
        });
    }
}
