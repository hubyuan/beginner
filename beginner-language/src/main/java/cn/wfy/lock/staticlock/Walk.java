package cn.wfy.lock.staticlock;

public class Walk {
    public static int num = 100;
    public static Walk walk = new Walk();

    // 静态
    public synchronized static int run() {
        int i = 0;
        while (i < 10) {
            try {
                num--;
                i++;
                System.out.println(Thread.currentThread().getName() + ":" + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    // 非静态
    public synchronized int walk() {
        int i = 0;
        while (i < 10) {
            try {
                num--;
                i++;
                System.out.println(Thread.currentThread().getName() + ":" + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
}

// 先建立两个测试类，这里我们默认循环10次
class T3 implements Runnable {
    @Override
    public void run() {
        Walk walk = new Walk();
        //Walk walk = Walk.walk;
        walk.walk();
    }
}

class T1 implements Runnable {
    @Override
    public void run() {
        Walk walk = new Walk();
        //Walk walk = Walk.walk;
        // 这里我依然用的new
        walk.run();
    }
}