package cn.wfy.proxy.httpServer;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/12/27
 */
@Slf4j
public class NettyProxyHttpServer {

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
                        Const.port2 = ipsStr.split(",");
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] s) {
        System.out.println("<<<<<<<<<<<<<<<<<");
        System.out.println("初始化host列表成功");

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(8);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(8);
        ServerBootstrap b = new ServerBootstrap();
        b.handler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                initAll();
            }
        });
        b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<Channel>() {

            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new NettyProxyServerHandler());
            }
        }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            ChannelFuture channelFuture = b.bind(7777).sync();
            ChannelFuture closeFuture = channelFuture.channel().closeFuture();
            closeFuture.sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}

@Slf4j
class NettyProxyServerHandler extends ChannelInboundHandlerAdapter {

    private Map<Channel, Channel> channelMap = new HashMap<>();
    private Map<Channel, ByteBuf> msgMap = new HashMap<Channel, ByteBuf>();//之所以保留这个map是担心，第一次建立连接时一次性无法获取客户端发来的全部信息
    NioEventLoopGroup toServerGroup = new NioEventLoopGroup(8);
    private Bootstrap bootstrap = new Bootstrap();

    @SuppressWarnings("rawtypes")
    public NettyProxyServerHandler() {
        //原来在这里我是想用serverbootstrap 下的childGroup去注册我自己直接新建的Channel的，结果发现根本注册不了，需要新生成一个bootstrap
        bootstrap.group(toServerGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true).handler(new ChannelInitializer() {

            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast("toServer handler", new ToServerHandler(channelMap));
//                ch.pipeline().addLast(new HttpServerCodec()).addLast(new HttpObjectAggregator(65536)).addLast("toServer handler", new ToServerHandler(channelMap));
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        if (channelMap.containsKey(ctx.channel())) {
            channelMap.remove(ctx.channel());
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        if (channelMap.containsKey(channel) && channelMap.get(channel) != null) {
            SocketAddress socketAddress = channel.localAddress();
            SocketAddress socketAddress1 = channel.remoteAddress();
            Channel toChannel = channelMap.get(channel);
            toChannel.writeAndFlush(msg);
        } else {
            ByteBuf buffer = null;
            if (msgMap.containsKey(channel) && msgMap.get(channel) != null) {
                buffer = msgMap.get(channel);
            } else {
                buffer = ctx.alloc().buffer(1024 * 2);
            }
            buffer.writeBytes((ByteBuf) msg);
            buffer.retain();
            msgMap.put(channel, buffer);

        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        final Channel channel = ctx.channel();
        if (!(channelMap.containsKey(channel) && channelMap.get(channel) != null)) {//如果是还没建立连接，需要对目标host和port进行解析
            if (msgMap.get(channel) != null) {
                byte[] b = new byte[msgMap.get(channel).readableBytes()];
                msgMap.get(channel).getBytes(0, b);
                String header = new String(b);
                String[] lineStrs = header.split("\\n");
                String host = "";
                int port = 80;
                int type = 0;                   //默认是http方式
                String hostTemp = "";

                for (int i = 0; i < lineStrs.length; i++) {//解析请求头
                    log.info(lineStrs[i]);
//                    System.out.println(lineStrs[i]);
                    if (i == 0) {
                        type = (lineStrs[i].split(" ")[0].equalsIgnoreCase("CONNECT") ? 1 : 0);
                    } else {
                        String[] hostLine = lineStrs[i].split(": ");
                        if (hostLine[0].equalsIgnoreCase("host")) {
                            hostTemp = hostLine[1];
                        }
                    }
                }
                if (hostTemp.split(":").length > 1) {
                    host = hostTemp.split(":")[0];
                    port = Integer.valueOf(hostTemp.split(":")[1].split("\\r")[0]);
                } else {
                    host = hostTemp.split(":")[0].split("\\r")[0];
                }
                final int requestType = type;
//                System.out.println("host is it:" + host + "=" + port);
                String[] hosts = newHostAndPort(host, port);
//                System.out.println("host is it:" + hosts[0] + "=" + Integer.parseInt(hosts[1]));

                String suffer = "";
                String lineStr = lineStrs[0];
                int i1 = lineStr.indexOf(String.valueOf(port));
                int i2 = lineStr.indexOf(" HTTP");
                String substring="";
                if (i1!=-1&&i2!=-1) {
                     substring = lineStr.substring(i1+String.valueOf(port).length(), i2);
                    System.out.println(lineStr);
                    System.out.println(substring);
                }
                System.out.println("connet to "+hosts[0]+ Integer.parseInt(hosts[1]));
                ChannelFuture future = bootstrap.connect(hosts[0], Integer.parseInt(hosts[1])).sync();
                if (future.isSuccess()) {         //建立到目标服务器的连接成功，把两者的连接映射放到map，方便后续使用
                    channelMap.put(channel, future.channel());
                    channelMap.put(future.channel(), channel);
                    if (requestType == 1) {      //https请求的话，直接返回给客户端下面这句话就行，客户端会在建立的通道上继续请求。
                        ByteBuf buffer = channel.alloc().buffer("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes().length);
                        buffer.writeBytes("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes());
                        channel.writeAndFlush(buffer);
                        msgMap.get(channel).release();
                    } else {
                        future.channel().writeAndFlush(msgMap.get(channel));
                        msgMap.get(channel).release();
                    }
                    log.info("=======连接建立成功");
//                    System.out.println("=======连接建立成功");
                } else {
                    log.info("=========connect failing");
//                    System.out.println("=========connect failing");
                }
            }
        }
    }

    private String[] newHostAndPort(String host, int port) {
        if (judge(host)) {
            return new String[]{host, String.valueOf(port)};
        }
        return filterHost(host, port);
    }

    //检查字母
    private boolean judge(String charStr) {
        char[] s = charStr.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')) {
                return true;
            }
        }
        return false;
    }

    //查找算法
    private String[] filterHost(String ip, int port) {

        String[] ip1 = Const.ip1;
        String[] ip2 = Const.ip2;
        String[] port1 = Const.port1;
        String[] port2 = Const.port2;

        for (int i = 0; i < ip1.length; i++) {
            for (int j = 0; j < port1.length; j++) {
                if (ip.equals(ip1[i])) {
                    ip = ip2[i];
                }
                if (String.valueOf(port).equals(port1[j])) {
                    port = Integer.parseInt(port2[j]);
                    return new String[]{ip, String.valueOf(port)};
                }
            }
        }
        return new String[]{ip, String.valueOf(port)};
    }

}

class ToServerHandler extends ChannelInboundHandlerAdapter {

    private Map<Channel, Channel> map = null;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("代理到目标服务器的channel handler出错：");
        cause.printStackTrace();
        if (map.containsKey(ctx.channel())) {
            map.remove(ctx.channel());
        }
    }

    public ToServerHandler(Map<Channel, Channel> map) {
        this.map = map;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        Channel toChannel = map.get(channel);
        toChannel.writeAndFlush(msg);
    }

}