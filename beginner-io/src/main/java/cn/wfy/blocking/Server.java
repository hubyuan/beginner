package cn.wfy.blocking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Integer port = 8999;
    private static ServerSocket server;

    public static void start() throws IOException {
        server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            new Thread(new ServerHander(socket)).start();
        }

    }
}
