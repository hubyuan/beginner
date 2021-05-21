package cn.wfy.proxy.httpServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class Main implements CommandLineRunner {

//    @Value("inetPort")
    private String inetPort;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("<<<<<<<<<<<<<<<<<");
        initAll();
        System.out.println("初始化host列表成功");

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(8);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(8);
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<Channel>() {

            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new NettyProxyServerHandler());
            }
        }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
//            b.bind(Integer.parseInt(inetPort)).sync();
            b.bind(9090).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void initAll() {

        try {
            if (Const.ip1 == null) {
                Properties properties = PropertiesLoaderUtils.loadAllProperties("application.yml");

                for (Object key : properties.keySet()) {
                    if (key.equals("ip1")) {
                        String ipsStr = String.valueOf(properties.get(key));
                        Const.ip1 = ipsStr.split(",");
                    }
                    if (key.equals("port1")) {
                        String ipsStr = String.valueOf(properties.get(key));
                        Const.port1 = ipsStr.split(",");
                    }
                    if (key.equals("ip2")) {
                        String ipsStr = String.valueOf(properties.get(key));
                        Const.ip2 = ipsStr.split(",");

                    }
                    if (key.equals("port2")) {
                        String ipsStr = String.valueOf(properties.get(key));
//                        Const.port2 = ipsStr.split(",");
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
