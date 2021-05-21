package cn.wfy.proxy.better;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;

public class HeaderUtil {
    /**
     * @methodName: addHeaders
     * @description: 添加headers信息，响应客户端
     * @auther: CemB
     * @date: 2018/12/20 17:18
     */
    public static void addHeaders(ChannelFuture future, Object request) {
        if (request instanceof HttpRequest) {
            HttpRequest msg = (FullHttpRequest) request;
            msg.headers().set("111", "222");
            future.channel().writeAndFlush(msg);
        } else {
            future.channel().writeAndFlush(request);
        }
    }
}
