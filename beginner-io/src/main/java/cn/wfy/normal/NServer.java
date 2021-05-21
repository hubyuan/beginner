package cn.wfy.normal;

import com.alibaba.fastjson.util.IOUtils;
import javafx.concurrent.Task;
import lombok.SneakyThrows;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NServer extends ServerSocket {


    private Socket socket;
    private static final int SERVER_PORT = 8899; // 服务端端口

    public NServer() throws IOException {
        super(SERVER_PORT);
    }

    public void load() throws IOException {

        while (true) {
            // server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
            Socket socket = this.accept();
            /**
             * 我们的服务端处理客户端的连接请求是同步进行的， 每次接收到来自客户端的连接请求后，
             * 都要先跟当前的客户端通信完之后才能再处理下一个连接请求。 这在并发比较多的情况下会严重影响程序的性能，
             * 为此，我们可以把它改为如下这种异步处理与客户端通信的方式
             */
            // 每接收到一个Socket就建立一个新的线程来处理它
            new Thread(new Task(socket)).start();
        }


    }

    class Task implements Runnable {

        private Socket socket;

        public Task(Socket socket) {
            this.socket = socket;
        }

        @SneakyThrows
        @Override
        public void run() {
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            String s = result.toString("UTF-8");
            System.out.println(System.currentTimeMillis()+" mes: "+s);


        }
    }

    public static void main(String[] args) throws IOException {
        NServer nServer = new NServer();
        nServer.load();


    }

}


