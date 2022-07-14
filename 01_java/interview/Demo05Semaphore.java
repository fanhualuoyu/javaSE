package interview;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore的使用方法：
 *      信号量的主要用于两个目的：
 *          1. 用于多个共享资源的互斥使用
 *          2. 用于并发线程数的控制
 */
public class Demo05Semaphore {
    public static void main(String[] args) {
        /**
         * 抢车位案例
         */
        Semaphore semaphore = new Semaphore(3); // 三个车位
        for (int i = 1; i <= 6; i++) { // 6个车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                    try {TimeUnit.SECONDS.sleep(3);} catch (Exception e) {e.printStackTrace();};
                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
