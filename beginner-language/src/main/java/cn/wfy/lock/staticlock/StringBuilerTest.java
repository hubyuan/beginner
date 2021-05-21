package cn.wfy.lock.staticlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class StringBuilerTest {
    static Map hashMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        ThreadPoolExecutor connetion = PoorThreadPool.getConnetion();
        for (int i = 0; i < 60; i++) {
            connetion.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    test1();
                }
            });
        }
        connetion.shutdown();
        while (true) {
            System.out.println(connetion.getActiveCount());

            System.out.println("wait...");
            if (connetion.isShutdown()) {
                System.out.println(hashMap);

                break;
            }
        }

    }

    private static void test1() {
        for (int i = 0; i < 100; i++) {
            StringBuilder stringBuilder = new StringBuilder("hhhhha");
            stringBuilder.append(i);
            stringBuilder.append(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stringBuilder.append(i);
            stringBuilder.append(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stringBuilder.append(i);
            stringBuilder.append(i);
//            System.out.println(Thread.currentThread().getName()+stringBuilder.toString());
            hashMap.put(Thread.currentThread().getName() + i, stringBuilder.toString());
//            System.out.println(hashMap);
        }

    }
}
