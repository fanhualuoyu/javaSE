package api;

import java.util.Arrays;

//Arrays类
public class Demo05Arrays {
    //与数组相关的工具类：里边提供了大量的静态方法
    public static void main(String[] args) {

        //按默认格式转变成字符串
        int[] intArray = {10, 20, 30};
        String intStr = Arrays.toString(intArray);
        System.out.println("intStr:" + intStr);

        //按照默认升序对数组元素进行排序
        int[] array1 = {2, 1, 3, 10, 6};
        Arrays.sort(array1);
        System.out.println("array1:" + Arrays.toString(array1));
        //按照字母升序
        String[] array2 = {"bbb", "aaa", "ccc"};
        Arrays.toString(array2);
        System.out.println(Arrays.toString(array2));
        //如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持
        

    }
}
