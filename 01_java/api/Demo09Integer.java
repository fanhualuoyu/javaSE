package api;

public class Demo09Integer {

    public static void main(String[] args) {
        //基本类型 -> 字符串
        int i1 = 100;
        String s1 = i1 + "";
        System.out.println(s1 + 200);

        String s2 = Integer.toString(100);
        System.out.println(s2 + 200);

        String s3 = String.valueOf(100);
        System.out.println(s3 + 200);

        //字符串 -> 基本类型
        int i = Integer.parseInt(s1);
        System.out.println(i - 10);
    }
}
