package cn.wfy.proxy.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.util.Properties;


@Slf4j
public class SocketHandle extends Thread {

    public String BE_IP;
    public Integer BE_PORT;
    public String TO_HOST;
    public Integer TO_PORT;

    private String[] ips;
    private String[] ports;

    private Socket socket;

    public SocketHandle(Socket socket) {
        this.socket = socket;
        try {
            if (ips == null) {
                Properties properties = PropertiesLoaderUtils.loadAllProperties("application.yml");

                for (Object key : properties.keySet()) {
                    if (key.equals("ips")) {
                        String ipsStr = String.valueOf(properties.get(key));
                        ips = ipsStr.split(",");
                    }
                    if (key.equals("ports")) {
                        BE_PORT = Integer.valueOf(String.valueOf(properties.get(key)));
                    }
                    if (key.equals("toips")) {
                        TO_HOST = String.valueOf(properties.get(key));

                    }
                    if (key.equals("toports")) {
                        String portsStr = String.valueOf(properties.get(key));
                        ports = portsStr.split(",");
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {


        OutputStream clientOutput = null;
        InputStream clientInput = null;
        Socket proxySocket = null;
        InputStream proxyInput = null;
        OutputStream proxyOutput = null;
        try {
            clientInput = socket.getInputStream();
            clientOutput = socket.getOutputStream();
            String line;
            String host = "";
            StringBuilder headStr = new StringBuilder();
            //读取HTTP请求头，并拿到HOST请求头和method

            Reader reader = new InputStreamReader(clientInput);
            BufferedReader input = new BufferedReader(reader);
            while (null != (line = input.readLine())) {
                log.info(line);
                headStr.append(line + "\r\n");
                if (line.length() == 0) {
                    break;
                } else {
                    String[] temp = line.split(" ");
                    if (temp[0].contains("Host")) {
                        host = temp[1];
                    }
                }
            }
            String type = headStr.substring(0, headStr.indexOf(" "));
            //根据host头解析出目标服务器的host和port
            String[] hostTemp = host.split(":");
            host = hostTemp[0];
            int port = 80;
            if (hostTemp.length > 1) {
                port = Integer.valueOf(hostTemp[1]);
            }
            //连接到目标服务器

            for (int i = 0; i < ips.length; i++) {
                if (host.equals(ips[i]) && (port == BE_PORT || port == BE_PORT - 2)) {
                    int anInt = Integer.parseInt(ports[i]);
                    if (port == BE_PORT - 2) {
                        anInt = anInt - 2;
                    }
                    proxySocket = new Socket(TO_HOST, anInt);
                    break;
                }
            }
            if (proxySocket == null) {
                proxySocket = new Socket(host, port);

            }

            proxyInput = proxySocket.getInputStream();
            proxyOutput = proxySocket.getOutputStream();
            //根据HTTP method来判断是https还是http请求
            if ("CONNECT".equalsIgnoreCase(type)) {//https先建立隧道
                clientOutput.write("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes());
                clientOutput.flush();
            } else {//http直接将请求头转发
                proxyOutput.write(headStr.toString().getBytes());
            }
            //新开线程转发客户端请求至目标服务器
            new ProxyHandleThread(clientInput, proxyOutput).start();
            //转发目标服务器响应至客户端
            while (true) {
                clientOutput.write(proxyInput.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (proxyInput != null) {
                try {
                    proxyOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (proxyOutput != null) {
                try {
                    proxyOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (proxySocket != null) {
                try {
                    proxySocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientInput != null) {
                try {
                    clientInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientOutput != null) {
                try {
                    clientOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
