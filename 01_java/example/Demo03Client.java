package example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//客户端
public class Demo03Client {
    public static void main(String[] args) throws IOException {
        //创建一个客户端对象Socket
        Socket socket = new Socket("127.0.0.1",8888);
        //获取网络字节输出流
        OutputStream os = socket.getOutputStream();
        //使用网络字节输出流中的write方法，给服务器发送数据
        os.write("你好，服务器".getBytes());
        //获取服务器返回的数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //释放资源(socket)
        os.close();
        is.close();
    }
}
