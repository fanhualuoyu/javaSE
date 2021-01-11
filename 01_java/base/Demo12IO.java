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
        //show4();

        //字符输出流
        //show5();

        //字节缓冲流
        //show6();

        //字符缓冲流
        show7();
    }


    //字节输出流：OutputStream(抽象类)【内存中的内容写到磁盘上】
    private static void show1() throws IOException {
        //FileOutPutStream:文件字节输出流
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("01_java\\file\\a.txt",true); //true表示开启追加写，否则会覆盖原文件
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
        FileInputStream fileInputStream = new FileInputStream("01_java\\file\\a.txt");
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
        FileInputStream fileInputStream = new FileInputStream("01_java\\file\\a.txt");
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
        FileReader fileReader = new FileReader("01_java\\file\\b.txt");
//        int len = 0;
//        while ((len = fileReader.read()) != -1) {
//            System.out.println((char) len);
//        }
        //一次读取多个字符
        char[] cs = new char[1024];
        int l = 0;
        while ((l = fileReader.read(cs)) != -1) {
            System.out.println(new String(cs, 0, l));
        }
    }

    //字符输出流
    private static void show5() throws IOException {
        FileWriter fileWriter = new FileWriter("01_java\\file\\b.txt");
        fileWriter.write("abc");
        fileWriter.flush(); //刷新缓冲区，把内存中的数据刷新到文件中
        fileWriter.close();
    }

    //字节缓冲流
    private static void show6() throws IOException {
        //输出流
        FileOutputStream fileOutputStream = new FileOutputStream("01_java\\file\\d.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(new byte[] {97,98,99});
        bufferedOutputStream.flush();
        bufferedOutputStream.close();

        //输入流
        FileInputStream fileInputStream = new FileInputStream("01_java\\file\\d.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int len = 0;
        while ((len = bufferedInputStream.read()) != -1) {
            System.out.println(len);
        }
        bufferedInputStream.close();
    }

    //字符缓冲流
    private static void show7() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("01_java\\file\\h.txt"));
        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("z");
            bufferedWriter.write("\r\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("01_java\\file\\h.txt"));
        //读取一行数据
        String line = bufferedReader.readLine();
        System.out.println(line);
        bufferedReader.close();
    }
}
