package cn.wfy.cache;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/18
 */
public class CacheLock {
    private static volatile Lock lock;


    //懒汉式，线程不安全
    public static Lock getLock() {
        if (lock==null){
            synchronized (CacheLock.class){
                if (lock == null) {
                    lock = new ReentrantLock();
                }
            }
        }
        return lock;
    }

    //饿汉式
    private Lock lock1 = new ReentrantLock();

    public Lock getLock1() {
        return lock1;
    }
}
class Test{
    public static void main(String[] args) {
        Lock lock = CacheLock.getLock();
        System.out.println(lock);
    }
}
