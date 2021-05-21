package cn.wfy.netty.websocket;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

import java.util.HashMap;
import java.util.Map;

public class Handler extends SimpleChannelInboundHandler<Object> {
    Channel m_channel;
    WebSocketServerHandshaker m_handshaker;
    String m_path;
    boolean m_loggedIn = false;

    static final String METHOD_CODE_REQUEST_LOGIN = "101";
    static final String METHOD_CODE_RESPONSE_LOGIN = "102";
    static final String METHOD_CODE_REQUEST_LISTEN_MEASURE = "103";
    static final String METHOD_CODE_RESPONSE_LISTEN_MEASURE = "104";
    static final String METHOD_CODE_PUSH_MEASURING_POINT = "105";
    static final String METHOD_CODE_REQUEST_HEARTBEAT = "1";
    static final String METHOD_CODE_PUSH_HEARTBEAT = "2";

    Handler(String path) {
        m_path = path;
    }

    void handleHttpFrame(ChannelHandlerContext ctx, FullHttpRequest req)
            throws Exception {
    }

    void handleWebsocketFrame(ChannelHandlerContext ctx, TextWebSocketFrame req)
            throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("methodCode", METHOD_CODE_PUSH_MEASURING_POINT);
        response.put("data", "aaaaaaaaaaaasdasd");
        send(JSONObject.toJSONString(response));
    }




    public void send(Object points) {
        Map<String, Object> response = new HashMap<>();
        response.put("methodCode", METHOD_CODE_PUSH_MEASURING_POINT);
        response.put("data", points);
        send(JSONObject.toJSONString(response));
    }

    public void send(String text) {
        m_channel.writeAndFlush(new TextWebSocketFrame(text));
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object req)
            throws Exception {
        if (req instanceof FullHttpRequest)
            handleHttpFrame(ctx, (FullHttpRequest) req);
        else if (req instanceof TextWebSocketFrame)
            handleWebsocketFrame(ctx, (TextWebSocketFrame) req);
    }


}
