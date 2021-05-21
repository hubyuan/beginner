package cn.wfy.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server
{
    EventLoopGroup m_boosGroup = new NioEventLoopGroup(8);
    EventLoopGroup m_workerGroup = new NioEventLoopGroup(8);
    ServerBootstrap m_bootstrap;

    private static Server s_this = new Server();

    public static Server share()
    {
        return s_this;
    }

    public boolean open(String path, int port)
    {
        try
        {
            m_bootstrap = new ServerBootstrap()
                    .group(m_boosGroup, m_workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new Initializer(path));

            m_bootstrap.bind(port).sync();
            System.out.println("打开 websocket 服务端口 " + port + " 成功");
        }
        catch (Exception e)
        {
            System.out.println("打开 websocket 服务端口 " + port + " 失败, " + e.toString());
            return false;
        }

        return true;
    }
}
