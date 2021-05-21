package cn.wfy.proxy;

import org.springframework.boot.CommandLineRunner;

import java.net.ServerSocket;

public class HttpProxy implements CommandLineRunner {

    private static Integer port = 9080;

    @Override
    public void run(String... args) throws Exception {
//监听端口
//        ServerSocket serverSocket = new ServerSocket(port);
//        for (; ; ) {
//            new SocketHandle(serverSocket.accept()).start();
//        }
    }
}
