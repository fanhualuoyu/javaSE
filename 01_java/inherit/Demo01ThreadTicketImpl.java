package inherit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多线程的问题
public class Demo01ThreadTicketImpl implements Runnable {
    //共享的资源
    private static int ticket = 100;

    //创建一个锁对象
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //1.同步代码块:用来保证线程安全
            synchronized (obj) {
                //l.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
                    ticket--;
                }
                //l.unlock();
            }
        }
    }

    //2.使用同步方法解决线程安全问题。同步方法中的锁对象就是new RunnableImpl()，也就是this
    public synchronized void payTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
            ticket--;
        }
    }

    //静态同步方法:他的锁对象是本类的class属性->class文件对象
    public static synchronized void payTicketStatic() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->正在卖第" + ticket + "张票");
            ticket--;
        }
    }

    //3.第三种解决方法：使用Lock机制

    /**
     * 1.在成员位置创建一个ReentrantLock对象
     * 2.在可能会出现安全问题的代码前调用lock方法
     * 3.在可能会出现安全问题的代码后调用unlock方法
     */
    Lock l = new ReentrantLock();
}
