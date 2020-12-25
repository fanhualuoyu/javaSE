package api;

// String类
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

        //查找字符串在本字符串中首次出现的索引位置，如果没有返回-1
        String origin = "helloWorld";
        int llo = origin.indexOf("llo");
        System.out.println("origin.index('llo'):" + llo);

        //截取字符串
        String s3 = "helloWorld";
        String s4 = s3.substring(5);
        System.out.println("s3.substring(5):" + s4);

    }
}
