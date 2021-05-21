package cn.wfy.topic;


import cn.wfy.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author hzk
 * @date 2018/3/10
 */
public class Recv1 {

    private static final String QUEUE_NAME = "test_queue_topic_one";
    private final static String EXCHANGER_NAME = "test_exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();

        //从连接中获取频道
        final Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String routingKey = "goods.add";
        //绑定队列到交换机 转发器
        channel.queueBind(QUEUE_NAME, EXCHANGER_NAME, routingKey);

        //保证一次只发一个
        channel.basicQos(1);

        DefaultConsumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("[1] Recv msg:" + msg);

//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    System.out.println("[1] done");
//                    channel.basicAck(envelope.getDeliveryTag(), false);
//                }
                System.out.println("[1] done");
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        boolean autoAck = false;

        channel.basicConsume(QUEUE_NAME, autoAck, consumer);

        System.out.println("[Consumer 1 start]");


    }


}

