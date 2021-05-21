package test.interrupt;

import java.util.Hashtable;

public class ThreadInterrupt extends Thread {
    @Override
    public void run() {
        long a = System.currentTimeMillis();
        int num = 5001230;
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += ((num * num - 1) + 90) / 43;
            hashtable.put(i, sum);
            Object o = hashtable.get(i);
            hashtable.put(i - 1, o);

        }
        long b = System.currentTimeMillis();

        System.out.println("执行时间 " + (b - a));

    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        ThreadInterrupt threadInterrupt = new ThreadInterrupt();
        threadInterrupt.run();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }
}
