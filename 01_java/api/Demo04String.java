package api;

// String类 和 StringBuilder类
public class Demo04String {
    public static void main(String[] args) {
        //使用空参构造
        String str1 = new String();
        System.out.println("第1个字符串：" + str1);

        //根据字符数组的内容，来创建对应的字符串
        char[] charArray = {'A', 'B', 'C'};
        String str2 = new String(charArray);
        System.out.println("第2个字符串：" + str2);

        //根据字节数组创建字符串
        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println("第3个字符串：" + str3);

        //直接创建:在字符串常量池中，其他创建方式不在
        String str4 = "hello";
        System.out.println("第4个字符串：" + str4);
        System.out.println("==================");

        //==是地址值的比较
        //字符串内容比较用下列方法；
        String str5 = "hello";
        String str6 = "hello";
        char[] charArray1 = {'h', 'e', 'l', 'l', 'o'};
        String str7 = new String(charArray1);
        System.out.println("==:" + (str5 == str6));
        System.out.println("!=:" + (str6 == str7));
        System.out.println("equals:" + str6.equals(str7));
        System.out.println("Hello:" + "Hello".equals(str5)); // 推荐
        System.out.println("Hello2:" + str5.equals("Hello"));// 不推荐 str5=null的话会报空指针异常
        //忽略大小写
        System.out.println("Hello==hello?:" + "Hello".equalsIgnoreCase(str5));
        System.out.println("==================");

        //字符串长度
        int length = "helloWorld".length();
        System.out.println("length:" + length);
        System.out.println("==================");

        //拼接字符串
        String s = "hello";
        String s1 = "world";
        String s2 = s.concat(s1);
        System.out.println("s2:" + s2);
        System.out.println("==================");

        //获取指定位置的字符
        char ch = "Hello".charAt(1);
        System.out.println("ch:" + ch);
        System.out.println("==================");

        //查找字符串在本字符串中首次出现的索引位置，如果没有返回-1
        String origin = "helloWorld";
        int llo = origin.indexOf("llo");
        System.out.println("origin.index('llo'):" + llo);
        System.out.println("==================");

        //截取字符串
        String s3 = "helloWorld";
        String s4 = s3.substring(5);
        System.out.println("s3.substring(5):" + s4);
        String s5 = s3.substring(0, 5);
        System.out.println("s3.substring(0,5):" + s5);
        System.out.println("==================");

        //将当前字符串拆分为字符数组
        char[] chars = "hello".toCharArray();
        System.out.println("chars:" + chars[0] + ",length:" + chars.length);

        //获得当前字符串底层的字节数组
        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        //将所有出现的老字符串替换成为新的字符串:public String replace(CharSequence oldString, CharSequence newString)
        String oldString = "How do you do?";
        String newString = oldString.replace("o", "*");
        System.out.println("oldString->newString:" + newString);
        System.out.println("==================");

        //分割字符串
        String splitString = "aaa,bbb,ccc";
        String[] array = splitString.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        String splitDot = "xxx.yyy.zzz";
        String[] array1 = splitDot.split("\\.");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        System.out.println("==================");

        //StringBuilder类：效率高，初始容量为16，容量不够时自动扩容
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder);
        StringBuilder stringBuilder1 = new StringBuilder("abc");
        System.out.println(stringBuilder1);
        StringBuilder stringBuilder2 = stringBuilder1.append("abc"); // 返回的是this，所以可以不用返回值
        System.out.println(stringBuilder2);
        System.out.println(stringBuilder1 == stringBuilder2);
        String str = stringBuilder2.toString(); // stringBuilder -> String
        System.out.println(str);
    }
}
