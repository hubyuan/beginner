package cn.wfy.normal;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

public class NClient extends Socket {

    private static final String SERVER_IP = "127.0.0.1"; // 服务端IP
    private static final int SERVER_PORT = 8899; // 服务端端口

    private Socket client;


    public NClient() throws IOException {
        super(SERVER_IP, SERVER_PORT);
        this.client = this;
        System.out.println(client.getLocalAddress() + "连接成功");
    }

    public void sendData(String mes) throws IOException {
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            outputStream = client.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(mes.getBytes());
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            dataOutputStream.close();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    int ii = i;
                    try (NClient nClient = new NClient(); ) {
                        nClient.sendData(String.valueOf(ii));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                }
            }
        };




    }
}
