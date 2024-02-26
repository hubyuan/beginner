package cn.wfy;


import cn.wfy.controller.BrokerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;

@SpringBootApplication
public class WebApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);

    }

}
