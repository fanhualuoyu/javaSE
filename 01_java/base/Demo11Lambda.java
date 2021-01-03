package base;

import inherit.Demo10ThreadPoolImpl;

/**
 * 函数式编程Lambda表达式
 */
public class Demo11Lambda {
    public static void main(String[] args) {
        //正常方法
        Demo10ThreadPoolImpl run = new Demo10ThreadPoolImpl();
        Thread t = new Thread(run);
        t.start();

        //使用匿名内部类
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "匿名内部类");
            }
        };
        new Thread(r).start();

        //Lambda表达式
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "Lambda表达式");
        }).start();

    }
}
