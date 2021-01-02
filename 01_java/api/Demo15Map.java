package api;

import java.util.*;

//Map接口及其子类
public class Demo15Map {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }

    /**
     * HashMap存储自定义类型键值
     * Map集合保证key是唯一的：
     *    作为Key的元素，必须重写HashCode方法和equals方法，以保证key唯一
     */

    //HashMap:无序的
    public static void demo1() {
        //public V put(K key, V value):key不重复，返回值v是null。key重复，会使用新value替换map中的重复的value,返回被替换的value
        Map<String, String> map = new HashMap<>();
        String v1 = map.put("a","A"); //null
        String v2 = map.put("a","a"); //A
        System.out.println(v1 + "->" + v2);
        System.out.println("=====================");

        map.put("b","B");
        map.put("c","C");
        System.out.println(map);
        System.out.println("=====================");

        //public V remove(Object key):把指定的键所对应的键值对元素在Map集合中删除，返回被删除元素的值v:key存在返回被删除的值;key不存在，返回null
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("张三",18);
        map1.put("李四",20);
        map1.put("王五",19);
        System.out.println(map1);
        Integer remove = map1.remove("张三");
        System.out.println(remove);
        Integer remove1 = map1.remove("麻子");
        System.out.println(remove1);
        System.out.println("=====================");

        //public V get(Object key)：根据指定的键，在Map集合中获取对应的值
        Integer get = map1.get("王五");
        System.out.println(get);
        System.out.println("=====================");

        //boolean containsKey(Object key)：是否包含指定的键
        boolean containsKey = map1.containsKey("张三");
        System.out.println(containsKey);
        System.out.println("=====================");

        Set<String> keySet = map1.keySet(); //获取所有的key
        for (String s : keySet) {
            System.out.println(s + "=" + map1.get(s));
        }
        System.out.println("=====================");

    }

    //Entry对象：用来记录键和值。当Map集合被创建的时候，就会在Map集合中创建一个Entry对象。
    private static void demo2() { //遍历
        //Set<Entry<K,V>> entrySet():返回此映射中包含的映射关系的Set视图
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",18);
        map.put("李四",20);
        map.put("王五",19);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }
        System.out.println("=====================");
    }

    //LinkedHashMap:有序的。继承了HashMap集合
    public static void demo3() {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        map.put("张三",18);
        map.put("李四",20);
        map.put("王五",19);
        System.out.println(map);
    }

    //Hashtable<K,V>：不允许存储空。它的子类Properties依然再用

}
