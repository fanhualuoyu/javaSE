package inherit;

//第二种方式：实现Runnable接口
public class Demo09Thread02 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }
}
