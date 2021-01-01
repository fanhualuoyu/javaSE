package api;

import domain.Demo12GenericName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//泛型
public class Demo12Generic {
    public static void main(String[] args) {
        Demo12GenericName<Integer> gc = new Demo12GenericName<>();
        gc.setName(1);
        System.out.println(gc.getName());
        System.out.println("============================");

        Demo12GenericName<String> gcStr = new Demo12GenericName<>();
        gcStr.setName("gcStr");
        System.out.println(gcStr.getName());
        System.out.println("===========================");

        gcStr.method("任意类型");
        System.out.println("===========================");

        Demo12GenericName.method2(1234);
        System.out.println("===========================");

        //泛型通配符?:只能用来接收参数，不能往集合里边存储
        Demo12Generic.printArray(new ArrayList<String>(Arrays.asList("a","b","c")));
    }

    /**
     * 泛型的上限限定：? extends E : ?只能和E一样或者是其子类
     * 泛型的下限限定：? super E : ?只能和E一样或者是其父类
     * @param list
     */
    public static void printArray(ArrayList<? extends Object> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}
