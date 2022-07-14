package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * java中的锁机制
 * 1. 公平锁和非公平锁(ReentrantLock(boolean flag):默认是非公平锁, Synchronized:非公平锁)
 *      1.1 公平锁：多个线程按照申请锁的顺序来获取锁，先来后到。
 *      1.2 非公平锁：多个线程获取锁的顺序并不是按照申请锁的顺序，有可能后申请的线程比先申请的线程优先。
 *                   获取锁在高并发的情况下，有可能会造成优先级反转或者饥饿现象。
 * 2. 可重入锁(又名递归锁)(ReentrantLock/Synchronized就是典型的可重入锁)
 *      2.1 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 *          在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
 *          也就是说，线程可以进入任何一个它已经拥有的锁锁同步着的代码块
 *      2.2 可重入锁最大的作用就是避免死锁
 * 3. 独占锁/共享锁
 *      3.1 独占锁：该锁一次只能被一个线程所持有。对ReentrantLock和Synchronized而言都是独占锁。
 *      3.2 共享锁：指该锁可被多个线程所持有。
 *          对ReentrantReadWriteLock其读锁是共享锁，其写锁是独占锁。
 *          读锁的共享锁可保证并发读是非常高效的，读写，写读，写写的过程是互斥的。
 * 4. 自旋锁
 *      4.1 指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，
 *          这样的好处是减少线程上下文的消耗，缺点是循环会消耗CPU。
 */
class Phone{
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendEmail()");
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwlLock = new ReentrantReadWriteLock();
    
    public void put(String key, Object value) {
        rwlLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            try {TimeUnit.SECONDS.sleep(300);} catch (Exception e) {e.printStackTrace();}
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");   
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            rwlLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        rwlLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：");
            try {TimeUnit.SECONDS.sleep(300);} catch (Exception e) {e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);   
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            rwlLock.readLock().unlock();
        }
    }
}

public class Demo02Lock {
    public static void main(String[] args) {
        
    }

    /**
     * 读写锁
     */
    public static void ReadWriteLock() {
        MyCache cache = new MyCache();
        
        for (int i = 0; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.get(tempInt + "");;
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 自旋锁
     */
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public static void SpinLock() {
        Demo02Lock lock = new Demo02Lock();
        
        new Thread(() -> {
            lock.myLock();
            try {TimeUnit.SECONDS.sleep(5);} catch (Exception e) {e.printStackTrace();}
            lock.unMyLock();
        }, "AA").start();
        
        try {TimeUnit.SECONDS.sleep(1);} catch (Exception e) {e.printStackTrace();}

        new Thread(() -> {
            lock.myLock();
            lock.unMyLock();
        }, "BB").start();
    }

    public void myLock() {
        // 加锁
        Thread thread = new Thread();
        while(!atomicReference.compareAndSet(null, thread)) {
            //自旋锁
        }
    }

    public void unMyLock() {
        // 解锁
        Thread thread = new Thread();
        atomicReference.compareAndSet(thread, null);
    }

    /**
     * 可重入锁的验证
     */
    public static void Reentrant() {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
