package cn.wfy.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description TODO
 * @auther wfy
 * @since 2022/4/21
 */
@Component
@Order(10)
@Slf4j
public class Customeraa implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("sssss........");
        log.error("bbbbbbbbbb...");
        new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
//                while (true) {
                    if (Excutor.messageQueue.size() > 0) {
                        log.error("do....");
                        synchronized (Excutor.LOCK) {
//                    Excutor.LOCK.wait();
                            Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
                            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream())) {
                                //先向消息队列发送命令
                                out.println("CONSUME");
                                out.flush();
                                out.close();

                            }
//                    Excutor.LOCK.notifyAll();
                        }
                    } else {
                        try {
                            Thread.sleep(1000);
                            log.error("wait....");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                    }
                }
            }

            ;


        };

    }
}
