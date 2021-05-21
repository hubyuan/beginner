package cn.wfy;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    String exchangeStr = "storageRealtime";

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public void sendMessage(String msg) {
        atomicInteger.addAndGet(1);
        if (atomicInteger.get() == 10000) {
            System.out.println("susscessful");
            atomicInteger.set(0);
        }
        rabbitTemplate.convertAndSend(exchangeStr, msg);
    }

}
