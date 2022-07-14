package interview;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier的使用方法：
 *      1. 让一组线程到达一个屏障(也可以叫同步点)时被阻塞，直到最后一个线程到达屏障时，
 *         屏障才会打开门，所有被屏障拦截的线程才会继续干活，线程进入屏障通过CyclicBarrier的await()方法
 */
public class Demo04CyclicBarrier {
    public static void main(String[] args) {
        /**
         * 案例：
         *      集齐7颗龙珠才能召唤神龙
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {System.out.println("***召唤神龙");});
        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第：" + tempInt + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
