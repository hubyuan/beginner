package cn.wfy.send;

import cn.wfy.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.Date;

public class Send {
    private final static String QUEUE_NAME = "hell23o";

    public static void main(String[] args) throws Exception {

        send();

    }

    public static void send() throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();


        for (int i = 0; i < 10; i++) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "hello world" + i + new Date();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("utf-8"));
        }
    }
}
