package api;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.management.MBeanFeatureInfo;
import java.io.File;
import java.io.IOException;

//File类
public class Demo16File {
    public static void main(String[] args) throws IOException {
        //路径分隔符
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);
        System.out.println("==================");

        //文件名称分隔符
        String separator = File.separator;
        System.out.println(separator);
        System.out.println("==================");

        //File类中的方法
        show1();

        //File类中的判断方法
        show2();

        //File中的创建删除
        show3();

        //File中的遍历目录
        show4();
    }

    //File类中的方法
    private static void show1() {
        File f1 = new File("01_java\\file\\a.txt");
        File f2 = new File("a.txt");
        //获取绝对路径
        String absolutePath = f1.getAbsolutePath();
        System.out.println(absolutePath);
        String absolutePath1 = f2.getAbsolutePath();
        System.out.println(absolutePath1);
        System.out.println("==================");

        //路径是什么样就获取什么样子
        String path = f1.getPath();
        System.out.println(path);
        String path1 = f2.getPath();
        System.out.println(path1);
        System.out.println("==================");

        //获取名称:传递路径的结尾部分
        String name = f1.getName();
        System.out.println(name);
        String name1 = f2.getName();
        System.out.println(name1);
        System.out.println("==================");

        //文件的长度:单位是字节
        long length = f1.length();
        System.out.println(length);
        long length1 = f2.length();
        System.out.println(length1);
        System.out.println("==================");
    }

    //File类中的判断方法
    private static void show2() {
        File f1 = new File("01_java\\file\\a.txt");
        //判断是否存在
        System.out.println(f1.exists());
        System.out.println("==================");

        //判断此file是否是目录，或者是文件（路径必须是存在的，否则两个都返回false）
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println("==================");


    }

    //File中的创建删除
    private static void show3() throws IOException {
        File f1 = new File("01_java\\file\\a.txt");
        //创建文件
        boolean b1 = f1.createNewFile();
        System.out.println(b1);

        //创建文件夹
        File f2 = new File("01_java\\file\\cs");
        boolean b2 = f2.mkdir(); //不能创建多级文件夹[f2.mkdirs()可以创建多级文件夹]
        System.out.println(b2);

        //删除文件/文件夹[文件夹中有内容不会被删除]
        boolean b3 = f2.delete();
        System.out.println(b3);
        System.out.println("==================");
    }

    //File中的遍历目录（文件夹）
    private static void show4() {
        File f1 = new File("01_java");
        //返回一个String数组中
        String[] strings = f1.list();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("==================");

        //返回一个list数组
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
