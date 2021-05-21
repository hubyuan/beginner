package cn.wfy.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class Initializer extends ChannelInitializer<SocketChannel>
{
    String m_path;

    Initializer(String path)
    {
        m_path = path;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel)
            throws Exception
    {
        socketChannel.pipeline()
                     .addLast(new HttpServerCodec())
                     .addLast(new HttpObjectAggregator(65536))
                     .addLast(new ChunkedWriteHandler())
                     //.addLast(new WebSocketServerProtocolHandler(m_path, null, true))
                     .addLast(new Handler(m_path));
    }
}
