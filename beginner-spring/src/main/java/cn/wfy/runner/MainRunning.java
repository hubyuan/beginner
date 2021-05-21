package cn.wfy.runner;

import cn.wfy.service.IocTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
@Component
public class MainRunning implements CommandLineRunner {
    @Autowired
    private IocTestService iocTestService;


    @Override
    public void run(String... args) throws Exception {
        int i = iocTestService.hashCode();
        System.out.println(i);

    }
}
