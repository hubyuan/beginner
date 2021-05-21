package cn.wfy.proxy.handle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.SocketAddress;

public class HttpProxy implements CommandLineRunner {

    private static Integer port = 9090;

    @Override
    public void run(String... args) throws Exception {
//监听端口
        ServerSocket serverSocket = new ServerSocket(port);
        for (; ; ) {
            SocketAddress localSocketAddress = serverSocket.getLocalSocketAddress();
            new SocketHandle(serverSocket.accept()).start();
        }
    }
}
