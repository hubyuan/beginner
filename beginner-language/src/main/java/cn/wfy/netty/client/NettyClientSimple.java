package cn.wfy.netty.client;

import cn.wfy.netty.vo.SubscribeReqProto;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;

/**
 * Netty客户端编写
 *
 * @author Administrator
 */
public class NettyClientSimple {

    public static void main(String[] args) throws InterruptedException {
        goChild();
//        for (int i = 0; i < 30; i++) {
//            Thread.sleep(1000);
//            new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        goChild();
//                        System.out.println(Thread.currentThread().getName());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            };
//        }

    }

    private static void goChild() throws InterruptedException {
        // 首先，netty通过ServerBootstrap启动服务端
        Bootstrap client = new Bootstrap();

        //第1步 定义线程组，处理读写和链接事件，没有了accept事件
        EventLoopGroup group = new NioEventLoopGroup();
        client.group(group);

        //第2步 绑定客户端通道
        client.channel(NioSocketChannel.class);

        //第3步 给NIoSocketChannel初始化handler， 处理读写事件
        client.handler(new ChannelInitializer<NioSocketChannel>() {  //通道是NioSocketChannel
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                //字符串编码器，一定要加在SimpleClientHandler 的上面
//                ch.pipeline().addLast(new StringEncoder());
                ch.pipeline().addLast(new ProtobufEncoder());
                ch.pipeline().addLast(new DelimiterBasedFrameDecoder(
                        Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
                //找到他的管道 增加他的handler
                ch.pipeline().addLast(new ClientHand());
            }
        });

        //连接服务器
        ChannelFuture future = client.connect("127.0.0.1", 6666).sync();

        //发送数据给服务器


        SubscribeReqProto.SubscribeReq student = SubscribeReqProto.SubscribeReq.newBuilder().setProductName("张三")
                .setSubReqID(20).setAddress("北京").build();
        byte[] student2ByteArray = student.toByteArray();


//        future.channel().writeAndFlush(student2ByteArray);
        future.channel().writeAndFlush("1");


        //当通道关闭了，就继续往下走
        future.channel().closeFuture().sync();

        //接收服务端返回的数据
        AttributeKey<String> key = AttributeKey.valueOf("ServerData");
        Object result = future.channel().attr(key).get();
        System.out.println(result == null ? "" : result.toString());
    }

}