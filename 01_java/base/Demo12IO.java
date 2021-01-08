package base;

import java.io.*;
import java.util.Arrays;

//IO流
public class Demo12IO {

    public static void main(String[] args) throws IOException {
        //字节输出流：OutputStream(抽象类)【内容写到磁盘上】
        //show1();

        //字节输入流：InputStream(抽象类)【磁盘加载到内存上】
        //show2();

        //字节输入流一次夺取多个字节的方法
        //show3();

        //字符输入流
        //FileReader extends InputStreamReader extends Reader
        show4();
    }


    //字节输出流：OutputStream(抽象类)【内存中的内容写到磁盘上】
    private static void show1() throws IOException {
        //FileOutPutStream:文件字节输出流
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("D:\\web\\javaSE\\01_java\\file\\a.txt",true); //true表示开启追加写，否则会覆盖原文件
            fileOutputStream.write(97);
            fileOutputStream.write("\r\n".getBytes()); //换行
            fileOutputStream.write(new byte[] {65, 66, 67});
            fileOutputStream.write("\r\n".getBytes()); //换行
            fileOutputStream.write(new byte[] {68,69,70,71,72},1,2);
            fileOutputStream.write("\r\n".getBytes()); //换行
            String str = "字符串";
            byte[] bytes = str.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.write("\r\n".getBytes()); //换行
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }
    }

    //字节输入流：InputStream(抽象类)【磁盘加载到内存上】
    private static void show2() throws IOException {
        //FileInputStream:文件字节输入流
        FileInputStream fileInputStream = new FileInputStream("D:\\web\\javaSE\\01_java\\file\\a.txt");
        //读取文件中的一个字节
        int f1 = fileInputStream.read();
        System.out.print((char)f1);
        f1 = fileInputStream.read();
        System.out.print((char)f1);

        //读取所有内容
        while ((f1 = fileInputStream.read()) != -1){
            System.out.print((char)f1);
        }
        fileInputStream.close();
    }

    //字节输入流一次夺取多个字节的方法
    private static void show3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\web\\javaSE\\01_java\\file\\a.txt");
        byte[] bytes = new byte[2];
        int len = fileInputStream.read(bytes);
        System.out.println(len); //2
        System.out.println(Arrays.toString(bytes)); //[97,98]
        System.out.println(new String(bytes));
        System.out.println(new String(bytes,0, 1));
        fileInputStream.close();
    }

    //字符输入流
    //FileReader extends InputStreamReader extends Reader
    private static void show4() throws IOException {
        FileReader fileReader = new FileReader("D:\\web\\javaSE\\01_java\\file\\b.txt");
        int len = 0;
        while ((len = fileReader.read()) != -1) {
            System.out.println((char) len);
        }
    }
}
