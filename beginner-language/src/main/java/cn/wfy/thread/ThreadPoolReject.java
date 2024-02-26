package cn.wfy.thread;

/**
 * @Author: wangfangyuan
 * @Date: 2022/5/5 11:37
 */


import cn.wfy.netty.test.User;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class ThreadPoolReject {

    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;

    public static void main(String[] args) throws Exception {
        User user = new User();


aaa(user);
        // 创建线程池。线程池的"最大池大小"和"核心池大小"都为1(THREADS_SIZE)，"线程池"的阻塞队列容量为1(CAPACITY)。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CAPACITY));
        // 设置线程池的拒绝策略为"CallerRunsPolicy"
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        // 新建10个任务，并将它们添加到线程池中。
        for (int i = 0; i < 3; i++) {
            Runnable myrun = new MyRunnable("task-" + i);
            pool.execute(myrun);
        }

        // 关闭线程池
        pool.shutdown();
    }

    private static void aaa(User user) {
        if ("".equals(user.getName())) {
            System.out.println(12321);
        }
    }
}

class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " is running.");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
