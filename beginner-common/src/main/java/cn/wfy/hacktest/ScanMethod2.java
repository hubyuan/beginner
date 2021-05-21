package cn.wfy.hacktest;

import cn.wfy.util.LogManager;
import cn.wfy.util.LogUtil;

import java.io.IOException;
import java.net.*;
import java.util.Set;

/**
 * 扫描方式二：针对一个待扫描的端口的Set集合进行扫描
 */
public class ScanMethod2 implements Runnable {
    private static final LogUtil LOGGER = LogManager.getLogger();
    private String ip; // 目标IP
    private Set<Integer> portSet; // 待扫描的端口的Set集合
    private int threadNumber, serial, timeout; // 线程数，这是第几个线程，超时时间

    public ScanMethod2(String ip, Set<Integer> portSet, int threadNumber,
                       int serial, int timeout) {
        this.ip = ip;
        this.portSet = portSet;
        this.threadNumber = threadNumber;
        this.serial = serial;
        this.timeout = timeout;
    }

    public void run() {
        int port = 0;
        Integer[] ports = portSet.toArray(new Integer[portSet.size()]); // Set转数组
        try {
            InetAddress address = InetAddress.getByName(ip);
            Socket socket;
            SocketAddress socketAddress;
            if (ports.length < 1)
                return;
            for (port = 0 + serial; port <= ports.length - 1; port += threadNumber) {
                socket = new Socket();
                socketAddress = new InetSocketAddress(address, ports[port]);
                try {
                    socket.connect(socketAddress, timeout);
                    socket.close();
                    System.out.println("端口 " + ports[port] + " ：开放");
                    LOGGER.info("ip: " + ip + "端口： " + ports[port] + " ：开放", "open.log");

                } catch (IOException e) {
                    LOGGER.info("端口 " + ports[port] + " ：关闭", ip + "port.log");
//                     System.out.println("端口 " + ports[port] + " ：关闭");
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}