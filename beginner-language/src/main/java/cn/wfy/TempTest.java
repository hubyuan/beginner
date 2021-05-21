package cn.wfy;

import cn.wfy.util.Binary;
import cn.wfy.vo.TestVo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TempTest {
    HashMap<String, TestVo> hashMap = new HashMap();

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger);

    }

    private void aaa() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Binary.ten; i++) {
            if (i % 9999 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            TestVo testVo = new TestVo();
            testVo.setHello("343");
            testVo.setWorld("343");
            hashMap.put(String.valueOf(i), testVo);
        }


    }
}
