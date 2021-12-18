package cn.wfy.proxy.segmentfault;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;

public class HttpProxyClientHandle extends ChannelInboundHandlerAdapter {

    private Channel clientChannel;

    public HttpProxyClientHandle(Channel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse response = (FullHttpResponse) msg;
        //修改http响应体返回至客户端
        response.headers().add("test","from proxy");
        printMsg(response.copy());

        clientChannel.writeAndFlush(msg);
    }

    private void printMsg(FullHttpResponse copy) {
        ByteBuf content1 = copy.content();
        String s1 = content1.toString(CharsetUtil.UTF_8);
        System.out.println("响应参数：" + s1);
    }
}