package example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class Demo04Server {
    public static void main(String[] args) throws IOException {
        //创建服务器ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        //获取到请求的客户端对象Socket
        Socket socket = serverSocket.accept();
        //获取网络字节输入流
        InputStream is = socket.getInputStream();
        //读取客户端发送过来的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //获取网络字节输出流
        OutputStream os = socket.getOutputStream();
        os.write("收到".getBytes());
        //释放资源
        is.close();
        os.close();
    }
}
