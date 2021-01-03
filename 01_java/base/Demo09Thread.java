package base;
//Thread线程
import inherit.Demo09Thread01;
import inherit.Demo09Thread02;

public class Demo09Thread {

    public static void main(String[] args) {
        //第一种实现Thread的方法
        /**
         * 1.创建一个Thread类的子类
         * 2.在Thread类的子类中重写Thread类中的run方法，设置线程任务
         * 3.创建Thread类的子类对象
         * 4.调用Thread类中的方法start方法
         * 多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
         */
        Demo09Thread01 thread = new Demo09Thread01();
        thread.start(); //用来执行run方法。开辟新的栈空间
        for (int i = 0; i < 20; i++) {
            System.out.println("main: " + i);
        }

        //第二种方法
        /**
         * 1.创建一个Runnable接口的实现类
         * 2.在实现类中重写Runnable接口的run方法，设置线程任务
         * 3.创建一个Runnable接口的实现类对象
         * 4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象
         * 5.调用Thread类中的start方法，开启新的线程执行run方法
         */
        Demo09Thread02 demo09Thread02 = new Demo09Thread02();
        Thread thread1 = new Thread(demo09Thread02);
        thread1.start();

        //匿名内部类实现线程的创建
        //父类是Thread
        new Thread(){
          @Override
          public void run(){
              for (int i = 0; i < 20; i++) {
                  System.out.println(Thread.currentThread().getName() + "->" + "aaa");
              }
          }
        }.start();
        //线程的接口Runnable
        /**
        Runnable r = new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + "->" + "bbb");
                }
            }
        };
        new Thread(r).start();
         */
        new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + "->" + "bbb");
                }
            }
        }).start();
    }

}
