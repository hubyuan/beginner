package cn.wfy.proxy.httpServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class HttpServer {
    public void start(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
                            ch.pipeline().addLast(
                                    new HttpResponseEncoder());
                            // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
                            ch.pipeline().addLast(
                                    new HttpRequestDecoder());
                            ch.pipeline().addLast(
                                    new HttpServerHandler());
                            //增加自定义实现的Handler
                            ch.pipeline().addLast(new HttpServerCodec());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = b.bind(port).sync();

            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        initAll();
        HttpServer server = new HttpServer();
        server.start(7777);
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