package cn.wfy.lock.concurrent;

public interface MyLock {
    void lock();
    boolean tryLock();
    void unlock();
}
