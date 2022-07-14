package interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 *      1. 基本概念：线程池做的工作主要是控制运行的线程的数量，处理过程种将任务放入队列，然后在线程创建后启动这些任务，
 *         如果线程数量超过了最大数量超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行。
 *      2. 主要特点：线程复用；控制最大并发数；管理线程。
 * 
 * 线程池7大参数：
 *      public ThreadPoolExecutor(int corePoolSize,//线程池中的常驻核心线程数
 *                                int maximumPoolSize,//线程池能够容纳同时执行的最大线程数
 *                                long keepAliveTime,//多余的空闲线程的存活时间
 *                                TimeUnit unit,//keepAliveTime的单位
 *                                BlockingQueue<Runnable> workQueue,//任务队列，被提交但尚未被执行的任务
 *                                ThreadFactory threadFactory,//生成线程池中工作线程的线程工厂，用于创建线程一般用默认的即可
 *                                RejectedExecutionHandler handler)//拒绝策略，当队列满了并且工作线程大于等于线程池的最大线程数时如何
 * 
 * 线程池底层工作原理：
 *      1. 在创建了线程池后，等待提交过来的任务请求。
 *      2. 当调用execute()方法添加一个请求任务时，线程池会做如下判断：
 *          2.1 如果正在运行的线程数量小于corePoolSize，那么马上创建线程运行这个任务；
 *          2.2 如果正在运行的线程数量大于或等于corePoolSize，那么将这个任务加入队列；
 *          2.3 如果这时候队列满了且正在运行的线程数量还小于maximumPoolSize，那么还是要创建非核心线程立刻运行这个任务；
 *          2.4 如果队列满了且正在运行的线程数量大于或等于maximumPoolSize，那么线程池会启动饱和拒绝策略来执行。
 *      3. 当一个线程完成任务时，它会从队列中取下一个任务来执行。
 *      4. 当一个线程无事可做超过一定的时间（keepAliveTime）时，线程池会判断：
 *              如果当前运行的线程数大于corePoolSize，那么这个线程就被停掉。
 *              所以线程池的所有任务完成后它最终会收缩到corePoolSize的大小。
 * 
 * 线程池的拒绝策略：
 *      1. AbortPolicy(默认)：直接抛出RejectedExecutionException异常组织系统正常运行。
 *      2. CallerRunsPolicy："调用者运行"一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新的任务流量。
 *      3. DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务。
 *      4. DiscardPolicy：直接丢弃任务，不予任何处理也不抛出异常。如果允许任务丢失，这是最好的一种方案。
 */
public class Demo12ThreadPool {
    public static void main(String[] args) {
        
    }

    /**
     * 自定义线程池
     */
    public static void initThreadPool() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                                                            5,
                                                            1L, 
                                                            TimeUnit.SECONDS, 
                                                            new LinkedBlockingQueue<Runnable>(3),
                                                            Executors.defaultThreadFactory(), 
                                                            new ThreadPoolExecutor.AbortPolicy() );
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    /**
     * 三种线程池：
     *      1. newFixedThreadPool(int nThreads){return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())}
     *      2. newSingleThreadExecutor(){return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())}
     *      3. newFixedThreadPool(){return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>())}
     */
    public static void ThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 5个处理线程
        // ExecutorService threadPool = Executors.newSingleThreadExecutor(); // 1个处理线程
        // ExecutorService threadPool = Executors.newCachedThreadPool(); // N个处理线程

        // 模拟器10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
