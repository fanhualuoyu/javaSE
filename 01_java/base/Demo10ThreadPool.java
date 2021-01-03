package base;

import inherit.Demo10ThreadPoolImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池:
 *  1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
 *  2.创建一个类，实现Runnable接口，重写run方法，设置线程任务
 *  3.调用ExecutorService中的方法submit，传递线程任务(实现类)，开启线程，执行run方法
 *  4.调用ExecutorService中的方法shutdown销毁线程池
 */
public class Demo10ThreadPool {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //调用submit方法开启线程，执行run方法
        es.submit(new Demo10ThreadPoolImpl());
        es.submit(new Demo10ThreadPoolImpl());
        es.submit(new Demo10ThreadPoolImpl());
    }
}
