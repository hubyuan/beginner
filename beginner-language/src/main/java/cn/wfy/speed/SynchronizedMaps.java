package cn.wfy.speed;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SynchronizedMaps {

    static int testsize = 1000000;

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        aaa();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

        long l111 = System.currentTimeMillis();
        aaa1();
        long l11 = System.currentTimeMillis();
        System.out.println(l11 - l111);
    }

    public static void aaa() {
        Map hashMap = Collections.synchronizedMap(new HashMap());
        for (int i = 0; i < testsize; i++) {
            hashMap.put(i, i + "==" + i);
        }


    }

    public static void aaa1() {
        Map hashMap = new ConcurrentHashMap();
        for (int i = 0; i < testsize; i++) {
            hashMap.put(i, i + "==" + i);
        }
    }

    public static void aaa2() {
    }
}
