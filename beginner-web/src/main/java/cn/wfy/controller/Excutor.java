package cn.wfy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description TODO
 * @auther wfy
 * @since 2022/4/21
 */
public class Excutor {
    public static final String LOCK = "lock";

    // 队列存储消息的最大数量
    private final static int MAX_SIZE = 3;

    // 保存消息数据的容器
    public static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_SIZE);

    public void excutor() {
        String msg = messageQueue.poll();
        byte[] bytes;
        for (int i = 0; i < 1000; i++) {

            for (int j = 0; j < 1000; j++) {
                bytes = new byte[1024];
                bytes = msg.getBytes();
                byte[] clone = bytes.clone();

            }
        }
        bytes = null;

    }


    public void customer(String msg) {
        messageQueue.offer(msg);

    }

    public void excutor1(String msg) {
        synchronized (LOCK) {

            try {
//                LOCK.wait();
                Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
                try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
                    out.println(msg);
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
//                LOCK.notifyAll();
            }
        }

    }
}
