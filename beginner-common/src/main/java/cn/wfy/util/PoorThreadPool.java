package cn.wfy.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/***
 * 很poor的线程池
 * 自动关闭，要用的时候再重新创建
 */
public class PoorThreadPool {

    private static Integer capacity = 300;//缓存队列长度，用的有界
    private static Integer corePoolSize = 20;//不会关闭的核心池，我的为0，这样不消化线程资源
    private static Integer maxiMumPoolSize = 30;//使用完会关闭的线程
    private static Long keepAliveTime = 100l;//3s后关闭alive
    private static ThreadPoolExecutor poolExecutor = null;

    public static ThreadPoolExecutor getConnetion() {
        if (poolExecutor == null) {
            poolExecutor = new ThreadPoolExecutor(corePoolSize, maxiMumPoolSize, keepAliveTime, TimeUnit.SECONDS,  new ArrayBlockingQueue<>(capacity),new ThreadPoolExecutor.CallerRunsPolicy());
        }
        return poolExecutor;
    }
}
