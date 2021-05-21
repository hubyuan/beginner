package cn.wfy.run;

import cn.wfy.service.MyBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/21
 */
@Component
public class TestRunner implements CommandLineRunner{
    @Autowired
    private MyBaseService myBaseService;
    @Override
    public void run(String... args) throws Exception {



        while (true){
            System.out.println("start!!!");
            TimeUnit.SECONDS.sleep(3);
            List<Map> maps = myBaseService.selectTestDataByIdAndName("43","小二王");
            List<Map> maps1 = myBaseService.selectTestDataById("43");
            List<Map> maps2 = myBaseService.selectAll();

        }

    }
}
