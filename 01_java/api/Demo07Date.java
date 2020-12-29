package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Date类 和DateFormat类 和Calendar类
public class Demo07Date {

    public static void main(String[] args) throws ParseException {
        System.out.println(System.currentTimeMillis()); // 获取系统时间到1970.1.1 00:00:00经历了多少毫秒
        demo01();
        System.out.println("========");
        demo02();
        System.out.println("========");
        demo03();
        System.out.println("========");
        demo04();
        System.out.println("========");
        demo05();
        System.out.println("========");
        demo06();
    }

    //Date类
    private static void demo01() {
        Date date = new Date();
        System.out.println(date);
    }

    private static void demo02() {
        Date date = new Date(0L); // 参数为Long类型
        System.out.println(date);
    }

    private static void demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
    }

    /**
     * DateFormat类:是一个抽象类
     * SimpleDateFormat是其实现类:SimpleDateFormat(String pattern)
     * y 年
     * M 月
     * d 日
     * H 时
     * m 分
     * s 秒
     * yyyy-MM-dd HH:mm:ss
     * yyyy年MM月dd日 HH时mm分ss秒
     */
    private static void demo04() {
        Date date = new Date();
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleFormatter.format(date);
        System.out.println(format);
    }

    private static void demo05() throws ParseException {
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = simpleFormatter.parse("2020年12月29日 22时46分28秒");
        System.out.println(date);
    }

    /**
     * Calendar类：日历类，是一个抽象类，里边有一个静态方法getInstance，该方法返回Calendar类的子类对象
     * public static final int YEAR = 1; 年
     * public static final int MONTH = 2;月
     * public static final int DATE = 5;月中的某一天
     * public static final int DAY_OF_MONTH = 5;月中的某一天
     * public static final int HOUR = 10; 时
     * public static final int MINUTE = 12; 分
     * public static final int SECOND = 13; 秒
     */
    private static void demo06() {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println("=========");

        instance.set(Calendar.YEAR,9999); //设置年
        instance.set(1998,3,6); //同时设置年月日

        instance.add(Calendar.YEAR, 2); //年增加两年
        instance.add(Calendar.MONTH,-1); // 月减少一个月

        int year = instance.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println("=========");

        int month = instance.get(Calendar.MONTH);
        System.out.println(month); //西方月份0——11
        System.out.println("=========");

        int date = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);
        System.out.println("=========");

        Date time = instance.getTime(); //日历对象改为日期对象
        System.out.println(time);
    }
}
