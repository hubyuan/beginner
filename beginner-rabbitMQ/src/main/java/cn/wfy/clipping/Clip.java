package cn.wfy.clipping;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author : wangfangyuan
 * @date : 2023/1/13 10:59
 */
@Slf4j
public class Clip {
    public static void main(String[] args) {
        Clip clip = new Clip();
        Runnable aaa = () -> {
            log.info("aaa");

            clip.running();
        };

        Runnable bbb = () -> {
            log.info("bbb");
            clip.doing();

        };
        Thread thread = new Thread(aaa);
        Thread thread1 = new Thread(bbb);
        thread.start();
        thread1.start();

    }
    CountDownLatch countDownLatch = new CountDownLatch(10);

    public void running() {
        log.info("12312312");
        while (true){

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object poll = arrayBlockingQueue.poll();
            if (poll!=null){
                log.info(String.valueOf(poll));
//                countDownLatch.countDown();

            }
        }

    }

    private void doing() {
        for (int i = 0; i < 10000; i++) {
            work(i);
        }
    }

    public static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(20000);

    public void work(int num) {
        arrayBlockingQueue.add(num);
    }
}
