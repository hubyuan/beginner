package cn.wfy.proxy.segmentfault.mock;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;


public class HttpProxyServerHandle extends ChannelInboundHandlerAdapter {

    private ChannelFuture cf;
    private String host;
    private int port;

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            System.out.println("请求方法名： " + httpRequest.method().name());
            //对不同的路径进行处理
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求favicon.ico");
            }
            // 返回的内容
            ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
            // http的响应
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            //响应头设置
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            // 把响应内容写回到客户端
            ctx.writeAndFlush(response);
        } else { // https 只转发数据，不做处理
            if (cf == null) {
                //连接至目标服务器
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(ctx.channel().eventLoop()) // 复用客户端连接线程池
                        .channel(ctx.channel().getClass()) // 使用NioSocketChannel来作为连接用的channel类
                        .handler(new ChannelInitializer() {

                            @Override
                            protected void initChannel(Channel ch) throws Exception {
                                ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx0, Object msg) throws Exception {
                                        ctx.channel().writeAndFlush(msg);
                                    }
                                });
                            }
                        });
                cf = bootstrap.connect(host, port);
                cf.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (future.isSuccess()) {
                            future.channel().writeAndFlush(msg);
                        } else {
                            ctx.channel().close();
                        }
                    }
                });
            } else {
                cf.channel().writeAndFlush(msg);
            }
        }
    }


}