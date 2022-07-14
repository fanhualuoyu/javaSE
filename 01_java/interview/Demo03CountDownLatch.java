package interview;

import java.util.concurrent.CountDownLatch;

enum CountryEnum {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");
    private Integer retCode;
    private String retMessage;
    
    public Integer getRetCode() {
        return retCode;
    }
    public String getRetMessage() {
        return retMessage;
    }
    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static CountryEnum forEach_CountryEnum(int index) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if(index == element.getRetCode()) {
                return element;
            }
        }
        return null;
    }
}
/**
 * CountDownLatch的使用方法
 *      1. 当一些线程阻塞直到另一些线程完成一系列操作后才能被唤醒
 *      2. CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，调用线程会被阻塞。
 *         其他线程调用CountDown方法会将计数器减1(调用countDown方法的线程不会被阻塞)，
 *         当计数器的值变为0时，因调用await方法被阻塞的线程会被唤醒，继续执行。
 */
public class Demo03CountDownLatch {
    public static void main(String[] args) throws Exception{
        /**
         * 案例：
         *      6国被灭完，秦国统一华夏
         */
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦帝国，一统华夏");
    }

    /**
     * 案例：
     *      学生都走完之后班长才能走。
     * @throws Exception
     */
    public static void closeDoor() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门走人");
    }
}
