package cn.wfy.ioc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainTest implements CommandLineRunner {

    private ITestIoc testIoc;

    public void setTestIoc(ITestIoc testIoc) {
        this.testIoc = testIoc;

    }

    @Override
    public void run(String... args) throws Exception {
//        testIoc.test();
    }
}
