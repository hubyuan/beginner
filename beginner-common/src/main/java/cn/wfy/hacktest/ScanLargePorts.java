package cn.wfy.hacktest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScanLargePorts {

    /**
     * 多线程扫描目标主机指定Set端口集合的开放情况
     *
     * @param ip           待扫描IP或域名,eg:180.97.161.184 www.zifangsky.cn
     * @param portSet      待扫描的端口的Set集合
     * @param threadNumber 线程数
     * @param timeout      连接超时时间
     */
    public void scanLargePorts(String ip, Set<Integer> portSet,
                               int threadNumber, int timeout) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNumber; i++) {
            ScanMethod2 scanMethod2 = new ScanMethod2(ip, portSet,
                    threadNumber, i, timeout);
            threadPool.execute(scanMethod2);
        }
        threadPool.shutdown();
        while (true) {
            if (threadPool.isTerminated()) {
                System.out.println("扫描结束");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

/*    public static void main(String[] args) {
        ScanLargePorts largePorts = new ScanLargePorts();
        //方式2
        Set<Integer> ports = new LinkedHashSet<Integer>();

        for (int i = 8000; i < 9000; i++) {
            ports.add(i);
        }

        largePorts.scanLargePorts("47.115.73.184", ports, 20, 1000);
    }*/
}
