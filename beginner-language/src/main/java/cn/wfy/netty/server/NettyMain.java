package cn.wfy.netty.server;

import cn.wfy.thread.task.StatisticsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyMain {

    @Autowired
    private StatisticsController statisticsController;


    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start();
    }

}
