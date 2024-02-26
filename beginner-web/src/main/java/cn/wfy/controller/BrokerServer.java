package cn.wfy.controller;

/**
 * @Description TODO
 * @auther wfy
 * @since 2022/4/20
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 用于启动消息处理中心
 */

public class BrokerServer implements Runnable {

    public static int SERVICE_PORT = 9999;
    private Excutor excutor=new Excutor();

    private final Socket socket;


    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        )
        {
            while (true) {
                String str = in.readLine();
                if (str == null) {
                    continue;
                }
//                System.out.println("接收到原始数据：" + str);

                if (str.equals("CONSUME")) { //CONSUME 表示要消费一条消息
                    //从消息队列中消费一条消息
//                    String message = broker.consume();
//                    out.println(message);
                    excutor.excutor();
                    out.flush();
                } else if (str.contains("SEND:")){
                    excutor.customer(str);
                    out.flush();
                    //接受到的请求包含SEND:字符串 表示生产消息放到消息队列中
//                    broker.produce(str);
                }else {
                    System.out.println("原始数据:"+str+"没有遵循协议,不提供相关服务");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(SERVICE_PORT);
        while (true) {
            BrokerServer brokerServer = new BrokerServer(server.accept());
            new Thread(brokerServer).start();
        }
    }
}

