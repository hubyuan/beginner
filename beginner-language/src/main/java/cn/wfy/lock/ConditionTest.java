package cn.wfy.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/9/14
 */
public class ConditionTest {
    final Lock lock = new ReentrantLock();
    private int number = 0;
    final Condition condition = lock.newCondition();
    public void increment () throws InterruptedException {
        lock.lock();
        while (number!=0){
            condition.await();
        }
        number++;
        condition.signalAll();
        lock.unlock();

    }
    public void decrement () throws InterruptedException {
        while (number==0){
            condition.await();
        }
        number--;
        condition.signalAll();

    }
}
