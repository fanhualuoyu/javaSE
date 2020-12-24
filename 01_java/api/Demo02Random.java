package api;

import java.util.Random;

// Random类
public class Demo02Random {
    public static void main(String[] args) {
        Random r = new Random();

        // 获取随机的int数字，参数：左边右开
        int num = r.nextInt();
        System.out.println("随机数是：" + num);

        for (int i = 0; i < 10; i++) {
            int n = r.nextInt(10);
            System.out.println(n);
        }
    }
}
