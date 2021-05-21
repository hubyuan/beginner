package cn.wfy.proxy.server;

import org.springframework.stereotype.Component;

@Component
public class NettyMain {




    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start();
    }

}
