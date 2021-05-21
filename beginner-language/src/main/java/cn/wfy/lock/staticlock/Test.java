package cn.wfy.lock.staticlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t3 = new Thread(new T3());
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(t1);
        es.execute(t3);
        es.shutdown();
    }
}