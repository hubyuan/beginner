package cn.wfy.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.TimeUnit;

public class NettyClient {
    private Bootstrap b = new Bootstrap();
    private EventLoopGroup group;

    public NettyClient() {
        group = new NioEventLoopGroup();
        b.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                    }
                });
    }

    public void connect(String host, int port) {
        System.out.println("11111111111 connect " + host + " " + Thread.currentThread());
        b.connect(host, port).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                /*
                 * 这里就不是主线程了，这里是 netty 线程中执行
                 */
                if (future.isSuccess()) {
                    System.out.println("2222222222222 connect success " + host + " " + Thread.currentThread());
                } else {
                    System.out.println("333333333333333 connect failed " + host + " " + Thread.currentThread());
                    // 连接不成功，5秒后重新连接
                    future.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("4444444444444  reconnect " + host + " " + Thread.currentThread());
                            connect(host, port);
                        }
                    }, 5, TimeUnit.SECONDS);
                }
            }
        });
    }

    public void stop() {
        if (group != null) {
            group.shutdownGracefully();
            group = null;
        }
    }

    public static void main(String[] args) {
        String[] ips = new String[]{
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110",
                "192.168.6.110"
        };

        NettyClient nettyClient = new NettyClient();

        for (int i = 0; i < ips.length; i++) {
            nettyClient.connect(ips[i], 6666);
        }

        // 这里主线程提前退出了，但JVM进程没有退出
        System.out.println("main thread finish");
    }
}