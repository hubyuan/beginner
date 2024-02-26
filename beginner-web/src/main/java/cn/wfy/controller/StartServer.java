package cn.wfy.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description TODO
 * @auther wfy
 * @since 2022/4/21
 */
@Component
@Order(11)
public class StartServer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("start..................");
        System.out.println("aaaaaaaaaaaa");
        Excutor.messageQueue.add("one");
        try {
            ServerSocket server = new ServerSocket(BrokerServer.SERVICE_PORT);
            while (true) {
                BrokerServer brokerServer = new BrokerServer(server.accept());
                new Thread(brokerServer).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
