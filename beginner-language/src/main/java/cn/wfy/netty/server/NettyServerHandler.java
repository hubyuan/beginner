package cn.wfy.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author Gjing
 *
 * netty服务端处理器
 **/
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel c = ctx.channel();
        InetSocketAddress addr = (InetSocketAddress) c.remoteAddress();
        System.out.println("新连接 " + addr.getAddress().getHostAddress() + ":" + String.valueOf(addr.getPort()));
        log.info("Channel active......");
    }

    private ByteBuf byteBuf;






    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if(msg instanceof ByteBuf){
            System.out.println(((ByteBuf)msg).toString(Charset.defaultCharset()));
        }else {
            System.out.println("eeeeeeeeeeer");
        }

        System.out.println("read");
        ByteBuf m = (ByteBuf) msg;
        byteBuf.writeBytes(m);
        m.release();


//        ByteBuf m = (ByteBuf) msg;
//        byteBuf.writeBytes(m);
//        m.release();
//        while (true) {
//            int len = byteBuf.readableBytes();// 8192,8012
//
//            if (len >= 8) {
//                int T = byteBuf.getIntLE(0); // T 类型----------------
//                int L = byteBuf.getIntLE(4); // L 长度----------------
//                if ((len - 8) >= L) {
//                    ByteBuf V = byteBuf.slice(8, L); // V 完整数据------
//
//                    // -----数据管理-----
//                    byte[] dst = new byte[L]; // protobuf数据
//
//
//                    V.getBytes(0, dst, 0, L);
//
//
//
//                    ByteBuf readBytes = Unpooled.buffer();
//                    readBytes.writeBytes(dst);
//
//                    // -----------------
////                    new HandleData().handle(ProtocolType.get(T), readBytes, ctx);// 处理数据
//                    byteBuf.readerIndex(8 + L);
//                    byteBuf.discardReadBytes();
//                } else
//                    break;
//            } else
//                break;
//        }
//        log.info("服务器收到消息: {}", msg.toString());
//        ctx.write("你也好哦");
//        ctx.flush();
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常");

        cause.printStackTrace();
        ctx.close();
    }




    // 客户端断开
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel c = ctx.channel();

        InetSocketAddress addr = (InetSocketAddress) c.remoteAddress();
        System.out.println(("关闭 " + addr.getAddress().getHostAddress() + ":" + String.valueOf(addr.getPort())));
        log.info("关闭 " + addr.getAddress().getHostAddress() + ":" + String.valueOf(addr.getPort()));
    }

}
