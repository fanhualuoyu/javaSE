package interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列：
 *      当阻塞队列是空时，从队列中获取元素的操作将会被阻塞
 *      当阻塞队列是满时，从队列种添加元素的操作将会被阻塞
 * BlockingQueue的方法：
 * 方法类型         抛出异常        特殊值       阻塞        超时
 * 插入             add(e)         offer(e)    put(e)      offer(e, time, unit)
 * 移除             remove()       poll()      take()      poll(time, unit)
 * 检查             element()      peek()      不可用       不可用
 */
public class Demo06BlockingQueue {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /**
         * 抛出异常组：
         *      阻塞队列满时插入失败：抛出java.lang.IllegalStateException: Queue full异常
         *      阻塞队列空时移除失败：抛出java.util.NoSuchElementException异常
         * 特殊值组：
         *      插入方法：成功true,失败false
         *      移除方法：成功返回队列的元素，失败返回null
         * 阻塞组：
         *      阻塞队列满时插入：队列一直阻塞，直到put数据or响应中断退出
         *      阻塞队列空时移除：一直阻塞消费者线程直到队列可用
         * 超时组:
         *      阻塞队列满时，队列会阻塞生产者线程一定时间，超时后生产者线程会退出
         */
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        //blockingQueue.add("x"); // 抛出java.lang.IllegalStateException: Queue full异常

        System.out.println(blockingQueue.element()); // 元素空不空，队首元素是谁

        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        //blockingQueue.remove(); //抛出java.util.NoSuchElementException异常

        /**
         * 特殊值组
         */
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        System.out.println(blockingQueue.offer("c")); // 输出false

        System.out.println(blockingQueue.peek()); // 输出a

        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        System.out.println(blockingQueue.poll()); // 输出null

        /**
         * 阻塞组
         */
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d"); // 一直阻塞
        
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take(); // 一直阻塞

        /**
         * 超时组
         */
        blockingQueue.offer("a", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("b", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("c", 2L, TimeUnit.SECONDS);
        blockingQueue.offer("d", 2L, TimeUnit.SECONDS); // 阻塞，两秒后自己停止，返回false
    }
}
