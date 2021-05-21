package cn.wfy.proxy.httpServer;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import static io.netty.handler.codec.rtsp.RtspHeaderNames.CONNECTION;
import static io.netty.handler.codec.rtsp.RtspHeaderNames.CONTENT_LENGTH;

@Slf4j
public class HttpServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {





        if (msg instanceof HttpRequest) {
            DefaultHttpRequest request = (DefaultHttpRequest) msg;
            String uri = request.uri();
            if ("/favicon.ico".equals(uri)) {
                return;
            }
            log.info(new Date().toString());
            String s = null;
            if (s == null || s.length() == 0) {
                //这里我们的处理是回源到tomcat服务器进行抓取，然后
                //将抓取的内容放回到redis里面
                try {
                    HttpHeaders headers = request.headers();
                    String host = headers.get("Host");
                    boolean judge = judge(host);
                    URL url = null;
                    if (judge) {
                        url = new URL(uri);
                    } else {
                        String[] hostList = host.split(":");

                        hostList = filterHost(hostList);
                        String hostNew = hostList[0] + ":" + hostList[1];
                        url = new URL("http://" + hostNew );

                    }


                    log.info(url.toString());
                    URLConnection urlConnection = url.openConnection();
                    HttpURLConnection connection = (HttpURLConnection) urlConnection;
//                    connection.setRequestMethod("GET");
                    //连接
                    connection.connect();
                    //得到响应码
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                        StringBuilder bs = new StringBuilder();
                        String l;
                        while ((l = bufferedReader.readLine()) != null) {
                            bs.append(l).append("\n");
                        }
                        s = bs.toString();
                    }
                    connection.disconnect();
                } catch (Exception e) {
                    log.error("", e);
                    return;
                }
            }
            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(s != null ? s.getBytes() : new byte[0]));
            response.headers().set(CONTENT_TYPE, "text/html");
            response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
            response.headers().set(CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            ctx.writeAndFlush(response);
        } else {
            //这里必须加抛出异常，要不然ab测试的时候一直卡住不动，暂未解决
            throw new Exception();
        }
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
    private String[] filterHost(String[] hostList) {
        String[] newStr = null;
        String ip = hostList[0];
        String port = hostList[1];
        String[] ip1 = Const.ip1;
        String[] ip2 = Const.ip2;
        String[] port1 = Const.port1;
        String[] port2 = Const.port2;

        for (int i = 0; i < ip1.length; i++) {
            for (int j = 0; j < port1.length; j++) {
                if (ip.equals(ip1[i])) {
                    if (port.equals(port1[j])) {
                        newStr = new String[2];
                        newStr[0] = ip2[i];
                        newStr[1] = port2[j];
                        break;
                    }
                }
            }
        }
        if (newStr == null) {
            return hostList;
        } else {
            return newStr;
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}