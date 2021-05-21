package cn.wfy;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue realtimeQueue() {
        return new Queue("storageRealtime");
    }



}
