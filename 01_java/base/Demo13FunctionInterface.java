package base;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口：
 * Supplier<T>接口
 *      T get():用来获取一个泛型参数指定类型的对象数据
 *      Supplier<T>接口被称之为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会产生什么类型的数据
 * Consumer<T>接口
 *      void accept(T t)：消费一个指定泛型的数据
 *      默认方法：andThen
 * Predicate<T>接口
 *      对某种类型的数据进行判断
 *      boolean test(T t)
 *      默认方法:and,or
 * Function<T,R>接口
 *      转换类型的接口,根据类型T的参数获取类型R的结果
 *      R apply(T t)
 *      默认方法：andThen
 */
public class Demo13FunctionInterface {
    //定义方法，方法参数传递Supplier接口
    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

    //Consumer接口
    public static void consumer(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    //Consumer接口中默认方法andThen
    public static void consumerAndThen(String name, Consumer<String> consumer1, Consumer<String> consumer2) {
        consumer1.andThen(consumer2).accept(name);
    }

    //Predict接口
    public static boolean predicate(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }

    //Predicate接口中的默认方法and
    private static boolean predicateAnd(String s, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.and(predicate2).test(s);
    }

    //Function接口
    private static void change(String s, Function<String,Integer> function) {
        Integer in = function.apply(s);
        System.out.println(in);
    }

    public static void main(String[] args) {
        //Supplier接口:生产接口
        String s = getString(() ->{
            //生产一个字符串，并返回
            return "zhangSan";
        });
        //System.out.println(s);

        //Consumer接口:消费接口
        consumer(s, (name)->{
            System.out.println(name);
        });
        //Consumer接口中的默认方法andThen
        consumerAndThen(s, (name)->{
            System.out.println(s.toLowerCase());
        },(name)->{
            System.out.println(s.toUpperCase());
        });

        //Predicate接口
        boolean b = predicate(s, (str)->{
            return str.length() > 5;
        });
        System.out.println(b);
        //Predicate接口中的默认方法and
        boolean b1 = predicateAnd(s, (str)->{
            return str.length() > 5;
        }, (str)->{
            return str.contains("f");
        });
        System.out.println(b1);

        //Function接口
        change("1234", (str)->{
            return Integer.parseInt(str);
        });
    }
}
