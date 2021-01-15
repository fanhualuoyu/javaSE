package base;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream流
 */
public class Demo14Stream {
    //Stream流遍历集合
    private static void listStream() {
        List<String> list = new ArrayList<>();
        list.add("张三风");
        list.add("李四");
        list.add("王二");
        list.add("张二狗");
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name-> System.out.println(name));
    }

    //获取流的方式
    private static void getStream() {
        //1.所有Collection集合都可以通过stream方法获取流
        //List集合
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //Map集合
        Map<String, String> map = new HashMap<>();
        Set<String> set = map.keySet();
        Stream<String> stream1 = set.stream();
        Collection<String> values = map.values();
        Stream<String> stream2 = values.stream();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream3 = entries.stream();
        //2.Stream接口的静态方法of可以获取数据对应的流
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream4 = Stream.of(arr);
    }

    //Stream流中常用的方法
    private static void methodStream() {
        //Stream流只能被消费一次
        Stream<String> stream = Stream.of("张三", "李四", "王二", "麻子");
        //forEach是一个终结方法
//        stream.forEach((name)->{
//            System.out.println(name);
//        });
        //filter方法转换后还是Stream流
        Stream<String> stream1 = stream.filter((name) -> {
            return name.startsWith("张");
        });
        stream1.forEach((name)->{
            System.out.println(name);
        });
    }

    //map方法，将一个流中的元素映射到另一个流当中
    private static void mapStream() {
        Stream<String> stream = Stream.of("1","2","3","4");
        Stream<Integer> stream1 = stream.map((s -> Integer.parseInt(s)));
        stream1.forEach(s-> System.out.println(s));
    }

    //流中的count方法：一个终结方法
    private static void countStream() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }

    //流中的截取方法，返回的还是一个流
    private static void limitStream() {
        String[] arr = {"美羊羊","喜羊羊","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> limitStream = stream.limit(3);
        limitStream.forEach(s -> System.out.println(s));
    }

    //跳过元素，返回的还是一个流
    private static void skipStream() {
        String[] arr = {"美羊羊","喜羊羊","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> skipStream = stream.skip(3);
        skipStream.forEach(s -> System.out.println(s));
    }

    //concat方法合并流
    private static void concatStream() {
        Stream<String> stream = Stream.of("张三", "李四", "王二", "麻子");
        String[] arr = {"美羊羊","喜羊羊","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream1 = Stream.of(arr);
        Stream<String> concat = Stream.concat(stream, stream1);
        concat.forEach(s -> System.out.println(s));
    }

    public static void main(String[] args) {
        //Stream流遍历集合
        listStream();
        System.out.println("==================");
        //Stream流中常用的方法
        methodStream();
        System.out.println("==================");
        //map方法，将一个流中的元素映射到另一个流当中
        mapStream();
        System.out.println("==================");
        //Stream流中的count方法
        countStream();
        System.out.println("==================");
        //limit方法
        limitStream();
        System.out.println("==================");
        //skip方法
        skipStream();
        System.out.println("==================");
        //concat方法
        concatStream();
        System.out.println("==================");
    }
}
