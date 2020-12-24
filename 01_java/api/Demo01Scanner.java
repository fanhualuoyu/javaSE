package api;

import java.util.Scanner;

// Scanner类
public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 从键盘进行输入

        //获取键盘输入的int数字
        int num = sc.nextInt();
        System.out.println("输入的数字是：" + num);

        //获取键盘输入的字符串
        String str = sc.next();
        System.out.println("输入的字符串是：" + str);


    }
}
