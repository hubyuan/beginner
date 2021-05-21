package cn.wfy.lock.concurrent;

public interface OkLock {
   MyLock readLock();
   MyLock writeLock();
}
