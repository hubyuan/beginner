package cn.wfy.controller;

/**
 * @Description TODO
 * @auther wfy
 * @since 2022/4/20
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消息处理中心
 */
@Component
public class Broker {
    @Autowired
    private TestController testController;
    // 队列存储消息的最大数量
    private final static int MAX_SIZE = 3;

    // 保存消息数据的容器
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_SIZE);

    // 生产消息
    public  void produce(String msg) {
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷，不能继续放入消息！");
        }
        System.out.println("=======================");
    }

    // 消费消息
    public  String consume() {
        String msg = messageQueue.poll();


        System.out.println("=======================");

        return msg;
    }

}

