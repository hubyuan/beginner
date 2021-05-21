package cn.wfy.ioc;

import org.springframework.stereotype.Component;

@Component
public class TestIocImpl implements ITestIoc {

    public void test() {
        System.out.println("test...");
    }
}
