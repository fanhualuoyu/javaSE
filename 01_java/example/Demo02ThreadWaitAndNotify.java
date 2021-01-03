package example;

/**
 * 线程之间的通信：
 *  顾客线程：调用wait方法等待
 *  老板线程：调用notify方法唤醒
 */
public class Demo02ThreadWaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象
        Object obj = new Object();
        //创建一个顾客线程
        new Thread(){
          @Override
          public void run() {
              synchronized (obj) {
                  System.out.println("告知老板需要的包子数量");
                  try {
                      obj.wait(); //里边可以加参数，单位毫秒值。如果时间到了还没被唤醒就自己醒
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println("包子做好了，开吃！");
              }
          }
        }.start();
        //创建一个老板线程
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //花5秒钟做包子
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    System.out.println("包子做好了");
                    obj.notify();
                }
            }
        }.start();
    }
}
