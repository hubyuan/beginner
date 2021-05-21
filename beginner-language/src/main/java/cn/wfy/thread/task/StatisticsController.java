package cn.wfy.thread.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import javax.annotation.Resource;
import java.io.InputStream;

@Component
public class StatisticsController {
    boolean tag = true;

    @Resource
    private StatisticsServiceImp statisticsServiceImp;

    @Async("taskExecutor")
    public void run() throws InterruptedException {
        while (tag) {


            countDataThread();

            Thread.sleep(1000 * 3);
        }
    }

    private void countDataThread() {
        statisticsServiceImp.startToDo();
    }

    @Deprecated
    public void destory() {
        tag = false;
    }
}
