package inherit;

//第一种方式：实现Thread中的run方法
public class Demo09Thread01 extends Thread {

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("run:" + i);
            try {
                //程序睡眠。单位是毫秒
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //设置线程的名称
        setName("进程1");
        //获取线程名称
        String name = getName();
        System.out.println(name);
        //获取当前正在执行的线程
        Thread currentThread = Demo09Thread01.currentThread();
        System.out.println(currentThread);
    }

}
