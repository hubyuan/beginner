package cn.wfy.lock.atomic;


import cn.wfy.lock.staticlock.PoorThreadPool;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class AtomicTest {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        AtomicVo atomicVo = new AtomicVo();
        atomicVo.setDataTime("hh");
        atomicVo.setDatavalue("hhvv");
        HashMap hashMap = new HashMap();
        hashMap.put(atomicVo, atomicVo);
        System.out.println(hashMap);


        HashMap hashMap1 = new HashMap();
        hashMap1.put("123", "34234");
        System.out.println(hashMap1);
    }

    final static int a = 100;

    private static void test1() {


        ThreadPoolExecutor connetion = PoorThreadPool.getConnetion();
        for (int i = 0; i < 300; i++) {
            connetion.execute(new Runnable() {
                @Override
                public void run() {
                    test11(a);
                }
            });
        }
        connetion.shutdown();
    }

    private static void test11(int a) {
        a++;
        System.out.println(a);
    }


}
