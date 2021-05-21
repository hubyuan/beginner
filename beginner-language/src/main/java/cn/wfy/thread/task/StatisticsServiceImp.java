package cn.wfy.thread.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StatisticsServiceImp {


    @Async
    public void startToDo() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 10000; i++) {
            hashMap.put(i, i);
        }
        System.out.println(Thread.currentThread().getName());
    }
}
