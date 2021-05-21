package cn.wfy.lock.concurrent;

import java.util.stream.IntStream;

public class LockTest {
    public static void main(String[] args) {
        IntStream.range(0,100).forEach(vo -> new Runnable() {
            @Override
            public void run() {
                doing();

            }
        });
    }

    private static void doing() {

    }


}
