package cn.wfy.thread.runner;

import cn.wfy.thread.task.StatisticsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2147483647 - 1)
public class SRunner implements CommandLineRunner {

    @Autowired
    private StatisticsController statisticsController;

    @Override
    public void run(String... args) throws Exception {
//        statisticsController.run();
    }
}
