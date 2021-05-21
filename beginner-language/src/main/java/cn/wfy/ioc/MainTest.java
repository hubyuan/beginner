package cn.wfy.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class MainTest implements CommandLineRunner {

    @Autowired
    private TestIoc testIoc;

    @Override
    public void run(String... args) throws Exception {
        testIoc.test();
    }
}
