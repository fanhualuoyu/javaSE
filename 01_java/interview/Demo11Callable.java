package interview;

import java.util.concurrent.Callable;

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable实现多线程.....");        
    }

}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        // 有返回值，会抛异常
        return null;
    }

}



/**
 * 多线程中，3种获得多线程的方式
 * 
 */
public class Demo11Callable {
    public static void main(String[] args) {
        
    }
}
